package com.example.demo.repositories;


import com.example.demo.Models.Movie;
import com.example.demo.Models.UserFavorites;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavoritesRepository extends CrudRepository<UserFavorites, Integer> {


    List<UserFavorites> findAllByUserId(int userId);
    List<UserFavorites> getAllByUserId(int userId);


    UserFavorites findUserFavoritesByUserIdAndMovieId(int userId, int movieId);
}
