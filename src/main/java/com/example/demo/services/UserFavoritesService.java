package com.example.demo.services;

import com.example.demo.Models.UserFavorites;

import com.example.demo.repositories.UserFavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserFavoritesService {
    private final UserFavoritesRepository userFavoritesRepository;

    @Autowired
    public UserFavoritesService(UserFavoritesRepository userFavoritesRepository) {
        this.userFavoritesRepository = userFavoritesRepository;
    }


    public UserFavorites addToFavorites(int userId, int movieId) {


        // Check if the row already exists in the database
         // Create a new UserFavorites entity and save it to the database
            UserFavorites userFavorites = new UserFavorites();
            userFavorites.setUserId(userId);
            userFavorites.setMovieId(movieId);
            userFavoritesRepository.save(userFavorites);
            //List<UserFavorites> favoritesList= userFavoritesRepository.findAllByByUserIdAndMovieId(userId,movieId);

            return userFavorites;



    }
    public List<UserFavorites> getUserFavorites(int  userId) {
        List<UserFavorites> favoritesList = userFavoritesRepository.findAllByUserId(userId);
        return favoritesList;
    }

    public boolean removeFromFavorites(int userId, int movieId) {
        // Find the row in the database based on userId and movieId
       UserFavorites userFavorites = userFavoritesRepository.findUserFavoritesByUserIdAndMovieId(userId, movieId);
        if (userFavorites == null) {
            // The row does not exist, so we cannot remove it
            return false;
        }

        // Delete the row from the database
        userFavoritesRepository.delete(userFavorites);

        return true;


    }
}
