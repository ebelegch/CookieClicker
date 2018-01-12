package org.sid.dao;

import org.bson.Document;
import org.sid.entities.Joueur;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class JoueurDAO {
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> cookies;
	private Gson gson;
	
	private JoueurDAO() {
		gson = new Gson();
		mongoClient = new MongoClient();		
		database = mongoClient.getDatabase("cookiesDb");
		cookies = database.getCollection("cookies");
	}
	
	private static JoueurDAO instance;
	
	public static JoueurDAO getInstance() {
		if (null != instance) {
			return instance;
		}
		instance = new JoueurDAO();
		return instance;
	}
	
	public  String getJoeurs(){
		
		
		
		StringBuilder sb = new StringBuilder("[");
		for(Document joeur : cookies.find()){
			Joueur j = gson.fromJson(joeur.toJson(), Joueur.class);

			sb.append(j.toJSON()).append(",");
		}
		sb.deleteCharAt(sb.length() -1).append("]");
		
		return sb.toString();
	}
	
	

}
