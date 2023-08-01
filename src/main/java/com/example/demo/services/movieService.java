package com.example.demo.services;

import com.example.demo.Models.Movie;

import com.example.demo.repositories.movieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieService {
private final movieRepository movieRepo;

@Autowired
    public movieService(movieRepository movieRepo) {
        this.movieRepo = movieRepo;

}




    public List<Movie> searchMovies(String query){
        return movieRepo.findByNameContainingIgnoreCase(query);

    }
    public List<Movie> getLatestMovies(){
        return movieRepo.findTop10ByOrderByPublishDateDesc();

    }
    public Movie getMovieDetails(int id){
    return movieRepo.findMovieById(id);
    }

//    public boolean addToFavorites(int userId, int movieId) {
//        movieuser user = userRepo.findById(userId).orElse(null);
//        Movie movie = movieRepo.findById(movieId).orElse(null);
//
//        if (user != null && movie != null) {
//            UserFavorites userFavorites = new UserFavorites(user, movie);
//            userfavRepo.save(userFavorites);
//            return true;
//        }
//        return false;
//    }
//    public boolean removeFromFavorites(int userId, int movieId) {
//    //to check if the user and movie exist
//       movieuser user = userRepo.findById(userId).orElse(null);
//        Movie movie = movieRepo.findById(movieId).orElse(null);
//
//        if (user != null && movie != null) {
//            UserFavoritesId userFavoritesID = new UserFavoritesId(userId, movieId);
//            userfavRepo.deleteById(userFavoritesID);
//            return true;
//        }
//        return false;
//    }
}
