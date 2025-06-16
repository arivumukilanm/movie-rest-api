package com.example.movie_rest_api.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="Movie")
public class Movie {
	@Id
	@Column(name="movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String description;
	private int duration; // in minutes
	private int releaseYear;
	public Movie(Long id, String title, String description, int duration, int releaseYear) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.releaseYear = releaseYear;
	}
	public Movie() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	@ManyToOne
	@JoinColumn(name="genre_id")
	private Genre genre;
	
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	@OneToMany(mappedBy="movie",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CastMember> castMembers=new ArrayList<>();
	public List<CastMember> getCastMembers() {
		return castMembers;
	}
	public void setCastMembers(List<CastMember> castMembers) {
		this.castMembers = castMembers;
	}
	
	


}
