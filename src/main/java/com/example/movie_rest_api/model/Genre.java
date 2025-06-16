package com.example.movie_rest_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="Genre")
public class Genre {
	@Id
	@Column(name="genre_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private	Long id;
	
	private	String name;

	public Genre(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Genre() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="genre",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Movie> movies;

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
	
	

}
