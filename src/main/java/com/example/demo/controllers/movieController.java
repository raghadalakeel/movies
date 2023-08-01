package com.example.demo.controllers;

import com.example.demo.Models.Movie;
import com.example.demo.services.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/movies")
public class movieController {

    private movieService movService;
    @Autowired
    public movieController(movieService movService) {
        this.movService = movService;
    }



    @GetMapping("/latest")
    public ResponseEntity<List<Movie>> getLatestMovies() {
        List<Movie> latestMovies = movService.getLatestMovies();
        if (latestMovies.isEmpty()) {
            // If no movies are found, return a 404 Not Found status
            return ResponseEntity.notFound().build();
        } else {
            // If movies are found, return them with a 200 OK status
            return ResponseEntity.ok(latestMovies);
        }
    }

    @GetMapping("/search/movieName")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String name) {
        List<Movie> searchedMovies = movService.searchMovies(name);
        return ResponseEntity.ok(searchedMovies);
    }

    @GetMapping("/{Movieid}")
    public ResponseEntity<Movie> getMovieDetails(@PathVariable int Movieid) {
        Movie movieDetails = movService.getMovieDetails(Movieid);
        if (movieDetails != null) {
            return ResponseEntity.ok(movieDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
