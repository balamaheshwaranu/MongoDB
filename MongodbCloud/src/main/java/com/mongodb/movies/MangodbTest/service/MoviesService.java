package com.mongodb.movies.MangodbTest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.mongodb.movies.MangodbTest.dao.MovieDocumentMapper;
import com.mongodb.movies.MangodbTest.models.Movie;
import com.mongodb.movies.MangodbTest.dao.MovieDao;

@Service
@Configuration

public class MoviesService {
	
	@Autowired
	public MovieDao movieDao;
	
	
	 public List<Movie> getMovies() {
	    

	        List<Movie> movies =
	                movieDao
	                        .getMovies()
	                        .stream()
	                        .map(MovieDocumentMapper::mapToMovie)
	                        .collect(Collectors.toList());
	        Map<String, Object> result = new HashMap<>();
	        result.put("movies_list", movies);
	        return movies;
	    }

}
