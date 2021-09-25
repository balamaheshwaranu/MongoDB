package com.mongodb.movies.MangodbTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.movies.MangodbTest.models.Movie;
import com.mongodb.movies.MangodbTest.service.MoviesService;

@RestController
@CrossOrigin(origins = "*")
public class MovieController {
	
	@Autowired
	public MoviesService moviesService;
	
	@GetMapping(value = "/getMovies")
	public List<Movie> getMovies() {
		
		return moviesService.getMovies();
		
	}

}
