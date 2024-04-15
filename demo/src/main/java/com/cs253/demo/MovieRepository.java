package com.cs253.demo;

import org.springframework.data.repository.CrudRepository;
import com.cs253.demo.model.*;


public interface MovieRepository extends CrudRepository<Movie, Integer> {

}