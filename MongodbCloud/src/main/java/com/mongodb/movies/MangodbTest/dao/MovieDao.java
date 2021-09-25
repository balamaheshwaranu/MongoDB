package com.mongodb.movies.MangodbTest.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.*;
import com.mongodb.movies.MangodbTest.models.Movie;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class MovieDao  {
	
	@Autowired
	public MongoClient mongoclient;
	
	@Value("${spring.mongodb.uri}")
    private String connectionString;
	
	@Value("${spring.mongodb.database}")
	private String M_FLIX;
	
	public List<Document> getMovies() {
		
		 List<Document> movies = new ArrayList<>();
		mongoclient.getDatabase(M_FLIX).getCollection("movies").find().limit(10).iterator().forEachRemaining(movies::add);
		return movies;
		
	}

   
}
