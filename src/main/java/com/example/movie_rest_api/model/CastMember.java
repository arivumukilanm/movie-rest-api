package com.example.movie_rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="Cast Member")
public class CastMember {
	@Id
	@Column(name="castMember_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Long id;
	
	private	String actorName;
	private	String role;
	public CastMember(Long id, String actorName, String role) {
		super();
		this.id = id;
		this.actorName = actorName;
		this.role = role;
	}
	public CastMember() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	@JsonIgnore
	private Movie movie;
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	
}
