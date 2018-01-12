package org.sid.dao;

import org.bson.Document;
import org.sid.entities.Joueur;
import org.sid.entities.Match;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MatchDAO {
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> matchs;
	private Gson gson;
	
	private MatchDAO() {
		gson = new Gson();
		mongoClient = new MongoClient("localhost", 27017);		
		database = mongoClient.getDatabase("cookiesDb");
		matchs = database.getCollection("coockiesDb");
	}
	
	private static MatchDAO instance;
	
	public static MatchDAO getInstance() {
		if (null != instance) {
			return instance;
		}
		instance = new MatchDAO();
		return instance;
	}
	
	public Document generateMatchDocument(Match match) {
		Document doc = new Document()
				.append("joueur1", this.generateJoueurDocument(match.getJoueur1()))
				.append("Joueur2", this.generateJoueurDocument(match.getJoueur2()))
				.append("scoreJoueur1", match.getScoreJoeur1())
				.append("scoreJoueur2", match.getScoreJoueur2())
				.append("bonus", match.getBonus());
		return doc;
	}
	
	public Document generateJoueurDocument(Joueur joueur) {
		Document doc = new Document()
				.append("nom", joueur.getNom());
		return doc;
	}
	
	public void createMatch(Match match) {
		matchs.insertOne(generateMatchDocument(match));
		
	}
	
	public String getMatch(Long id) {		
		
		Document matchDocument = matchs.find(Filters.eq("id", id)).first();
		if (null == matchDocument) {
			return "{id:ana}";
		}
		Match match = gson.fromJson(matchDocument.toJson(), Match.class);
		return match.toJSONDetail();
	}
	
	public String getByName(String nom) {		
		
		Document matchDocument = matchs.find(Filters.eq("nom",nom)).first();
		if (null == matchDocument) {
			return "{nom:ana}";
		}
		Match match = gson.fromJson(matchDocument.toJson(), Match.class);
		return match.toJSONDetail();
	}
	
	


	
	public String getMatchEnCoursList() {
				
			StringBuilder sb = new StringBuilder("[");
			for (Document matchDocument : matchs.find()) {
				Match match = gson.fromJson(matchDocument.toJson(), Match.class);			
				sb.append(match.toJSON()).append(",");		
			}
			sb.deleteCharAt(sb.length()-1).append("]");
			return sb.toString();
		}
	

}
