package com.example.demo.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserFavorites {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;



    @Column(name = "movie_id")
    private Integer movieId;


    public void setUserId(int userId) {
        this.userId=userId;
    }

    public void setMovieId(int movieId) {
        this.movieId=movieId;
    }

}


