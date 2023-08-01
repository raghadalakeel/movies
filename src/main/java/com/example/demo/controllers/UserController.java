package com.example.demo.controllers;

import com.example.demo.Models.Movie;
import com.example.demo.Models.UserFavorites;
import com.example.demo.Models.movieuser;
import com.example.demo.repositories.userRepository;
import com.example.demo.services.UserFavoritesService;
import com.example.demo.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@RestController
@RequestMapping("/api2/users")
public class UserController {

    private userService service;
    private userRepository repo;
    @Autowired
    public UserController(userService service) {
        this.service = service;
    }
    @GetMapping(value = "/email",produces =MediaType.APPLICATION_JSON_VALUE )
    public movieuser getUser(@RequestParam String email) {
          movieuser user = service.getUserByEmail(email);
           return  user;
    }

//    @PostMapping(value="/add",produces = MediaType.APPLICATION_JSON_VALUE)
//    public  ResponseEntity<String>addUser(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName,@RequestParam String password) {
//      if (service.addUser(email,firstName,lastName,password)){
//
//          return ResponseEntity.ok("User have been added successfully");
//      }
//       return ResponseEntity.ok("user already exist");
//    }
@PostMapping("/add")
public ResponseEntity<Map<String, String>> addUser(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String password) {
    if (service.addUser(email, firstName, lastName, password)) {
        // User added successfully
        Map<String, String> response = new HashMap<>();
        response.put("message", "User have been added successfully");
        return ResponseEntity.ok(response);
    } else {
        // User already exists
        Map<String, String> response = new HashMap<>();
        response.put("message", "User already exists");
        return ResponseEntity.badRequest().body(response);
    }
}

}
