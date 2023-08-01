package com.example.demo.controllers;

import com.example.demo.Models.Movie;
import com.example.demo.Models.UserFavorites;
import com.example.demo.repositories.movieRepository;
import com.example.demo.services.UserFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api2/users/favorites")
public class userFavoritesController {

    @Autowired
    private UserFavoritesService service;
    private movieRepository movierepository;


    @Autowired
    public userFavoritesController(UserFavoritesService service, movieRepository movierepository) {
        this.service =service;
        this.movierepository = movierepository;
    }

    @PostMapping("/{userId}/{movieId}/add")
    public UserFavorites addToFavorites(@PathVariable int userId ,@PathVariable int movieId) {
        UserFavorites addedToFavorites = service.addToFavorites(userId, movieId);
     return addedToFavorites;
    }
    @GetMapping("/userId")
    public ResponseEntity<List<Movie>> getUserFavorites(@RequestParam int userId) {
        List<UserFavorites> favoritesList = service.getUserFavorites(userId);
        List<Movie> favoriteMovies = new ArrayList<>();

        for (UserFavorites favorite : favoritesList) {
            Optional<Movie> movie = movierepository.findById(favorite.getMovieId());
            movie.ifPresent(favoriteMovies::add);
        }
        return ResponseEntity.ok(favoriteMovies);
    }



    @DeleteMapping(value="/deleteMovie" )
    public ResponseEntity<String> removeFromFavorites(@RequestParam int userId ,@RequestParam int movieId) {
        boolean removedFromFavorites = service.removeFromFavorites(userId, movieId);
        String message;
        if (removedFromFavorites) {
            message = "The movie has been removed from favorites successfully!";
        } else {
            message = "We couldn't remove the movie";
        }
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

}