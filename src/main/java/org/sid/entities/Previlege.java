package org.sid.entities;

import java.io.Serializable;


public class Previlege implements Serializable {
	private Long id;
	private String nom;
	private int cout;
	
	public Previlege() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Previlege(String nom, int cout) {
		super();
		this.nom = nom;
		this.cout = cout;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public Long getId() {
		return id;
	}
	
	
}
