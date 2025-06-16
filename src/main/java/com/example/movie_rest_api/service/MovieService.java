package com.example.movie_rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_rest_api.exception.ResourceNotFoundException;
import com.example.movie_rest_api.model.Movie;
import com.example.movie_rest_api.repository.MovieRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class MovieService {
	
	@Autowired
	private MovieRepository mr;
	
	public Movie saveMovie(Movie movie) {
		Movie res=mr.save(movie);
		return res;
	}
	
	public Movie getMovie(Long id) {
		return mr.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie with id "+id+" not found") );
	}

	public List<Movie> findAllMovies() {

		return mr.findAll();
	}
	
	public void deleteMovie(Long id) {
		Movie movie=mr.findById(id).orElse(null);
		mr.delete(movie);
	}
	

	public List<Movie> getMoviesByGenreName(String genreName) {
		return mr.findByGenreName(genreName);
	}
	
	
	
	
	
}
