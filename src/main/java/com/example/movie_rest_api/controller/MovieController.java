package com.example.movie_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_rest_api.model.CastMember;
import com.example.movie_rest_api.model.Genre;
import com.example.movie_rest_api.model.Movie;
import com.example.movie_rest_api.service.GenreService;
import com.example.movie_rest_api.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	GenreService genreService;
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("Hello",HttpStatus.OK);
	}
	
	@PostMapping("/genre/save")
	public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre){
		
		try {
			
			Genre res=genreService.saveGenre(genre);
			return new ResponseEntity<Genre>(res,HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/genre/all")
	public ResponseEntity<List<Genre>> displayAllGenres(){
		
		List<Genre> genreList=genreService.findAllGenre();
		return new ResponseEntity<List<Genre>>(genreList,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/movie/save")
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
		
		for (CastMember cm : movie.getCastMembers()) {
	        cm.setMovie(movie);
	    }
		
		Movie result=movieService.saveMovie(movie);
		return new ResponseEntity<Movie>(result,HttpStatus.OK);
	}
	
	@GetMapping("/movie/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
		Movie movie=movieService.getMovie(id);	
		return new ResponseEntity<Movie>(movie,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/movie/all")
	public ResponseEntity<List<Movie>> displayAllMovies(){

		List<Movie> res=movieService.findAllMovies();
		return new ResponseEntity<List<Movie>>(res,HttpStatus.OK);

	}
	
	@DeleteMapping("/movie/delete/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable Long id){
		movieService.deleteMovie(id);
		return new ResponseEntity<String>("Deleted Movie with id :"+id,HttpStatus.OK);
		
	}
	
	@PutMapping("/movie/update/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable Long id,@RequestBody Movie updatedMovie){
		
		Movie movie=movieService.getMovie(id);
		movie.setTitle(updatedMovie.getTitle());
		movie.setDescription(updatedMovie.getDescription());
		movie.setDuration(updatedMovie.getDuration());
		movie.setReleaseYear(updatedMovie.getReleaseYear());
		
		movie.setGenre(updatedMovie.getGenre());
		
		movie.getCastMembers().clear();
		for(CastMember cm:updatedMovie.getCastMembers()) {
			cm.setMovie(movie);
			movie.getCastMembers().add(cm);
		}
		
		movieService.saveMovie(movie);
		
		return new ResponseEntity<Movie>(updatedMovie,HttpStatus.OK);
	}
	
	

}
