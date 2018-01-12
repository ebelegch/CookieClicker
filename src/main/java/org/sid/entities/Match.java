package org.sid.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




public class Match {
	private Long id;
	@Autowired
	private Joueur joueur1;
	@Autowired
	private Joueur joueur2;
	private Long scoreJoeur1;
//	private Timestamp demarrage ;
//	
//	
//	public Timestamp getDemarrage() {
//		return demarrage;
//	}
//	public void setDemarrage(Timestamp demarrage) {
//		this.demarrage = demarrage;
//	}
	public static final Gson gson = new Gson();
	public Long getScoreJoeur1() {
		return scoreJoeur1;
	}
	public void setScoreJoeur1(Long scoreJoeur1) {
		this.scoreJoeur1 = scoreJoeur1;
	}
	public Long getScoreJoueur2() {
		return scoreJoueur2;
	}
	public void setScoreJoueur2(Long scoreJoueur2) {
		this.scoreJoueur2 = scoreJoueur2;
	}
	private Long scoreJoueur2;
	public Long getDuree() {
		return duree;
	}
	public void setDuree(Long duree) {
		this.duree = duree;
	}
	private Long duree ;
	private Collection<Previlege> bonus;
	
	
	public Collection<Previlege> getBonus() {
		return bonus;
	}
	public void setBonus(Collection<Previlege> bonus) {
		this.bonus = bonus;
	}
	
	
	public Joueur getJoueur1() {
		return joueur1;
	}
	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}
	public Joueur getJoueur2() {
		return joueur2;
	}
	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}
	
	
	public Match(Joueur joueur1, Joueur joueur2, Integer dureeMinues) {
		super();
		long time = System.currentTimeMillis();
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		//this.demarrage = new Timestamp(time);
		this.duree=Duration.ofMinutes(15).toMinutes();

	}
	
	public String toJSONDetail() {
		return gson.toJson(this);		
	}
	public String toJSON() {
		final GsonBuilder builder = new GsonBuilder();
	    builder.excludeFieldsWithoutExposeAnnotation();
	    final Gson gsonShort = builder.create();
		
		return gsonShort.toJson(this);
	}
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}
}
