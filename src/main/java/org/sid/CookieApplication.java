package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.bson.Document;
import org.sid.entities.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class CookieApplication implements CommandLineRunner {
	
//	
//	private MongoClient mongoClient;
//	private MongoDatabase database;
//	private MongoCollection<Document> cookies;
//	private Gson gson;

	

	public static void main(String[] args) {
		SpringApplication.run(CookieApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("cest parti!");
	}
}
