package com.example.demo.repositories;

import com.example.demo.Models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface movieRepository extends CrudRepository<Movie, Integer> {
   List<Movie> findByNameContainingIgnoreCase(String query);
   List<Movie> findAll();
   Movie findMovieById(int id);


   List<Movie> findTop10ByOrderByPublishDateDesc();
}
