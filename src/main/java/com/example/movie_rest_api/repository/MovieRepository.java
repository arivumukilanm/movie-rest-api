package com.example.movie_rest_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie_rest_api.model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

	List<Movie> findByGenreName(String genreName);
	
}
