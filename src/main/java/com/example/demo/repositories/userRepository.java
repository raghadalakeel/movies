package com.example.demo.repositories;

import com.example.demo.Models.movieuser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends CrudRepository<movieuser,Integer > {

movieuser findById(int id);
boolean existsByEmail(String email);

    movieuser findByEmail(String email);
}
