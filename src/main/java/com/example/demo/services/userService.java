package com.example.demo.services;

import com.example.demo.Models.Movie;
import com.example.demo.Models.UserFavorites;
import com.example.demo.Models.movieuser;
import com.example.demo.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class userService {
    private final userRepository Repo;

    @Autowired
    public userService(userRepository repo) {
        Repo = repo;
    }


    public movieuser getUserByEmail(String email) {

        return Repo.findByEmail(email);
    }
    public boolean addUser(   String email,  String firstName, String lastName, String password) {
        if (!Repo.existsByEmail(email)) {
            movieuser user = new movieuser(email,firstName,lastName,password);
            Repo.save(user);
            return true;
        } else return false;
    }

}
