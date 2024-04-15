package com.cs253.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs253.demo.model.*;
import com.cs253.demo.MovieService;

@Service
public class MovieService {
  
  @Autowired
  private MovieRepository movieRepository;

  @SuppressWarnings("null")
  public Movie saveDetails(Movie movie) {
    return movieRepository.save(movie);
  }

  public Iterable<Movie> getAllDetails() {
    return movieRepository.findAll();
  }

  @SuppressWarnings("null")
  public Movie getById(Integer movieId) {
    return movieRepository.findById(movieId).orElse(null);
  }

} 

