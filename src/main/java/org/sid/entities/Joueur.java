package org.sid.entities;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Joueur {
	
	private Long id;
	private String nom;

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public Joueur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Joueur(String nom) {
		super();
		this.nom = nom;
	}
	
	public String toJSON() {
		final GsonBuilder builder = new GsonBuilder();
	    builder.excludeFieldsWithoutExposeAnnotation();
	    final Gson gsonShort = builder.create();
		
		return gsonShort.toJson(this);
	}
	
}
