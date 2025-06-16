package com.example.movie_rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_rest_api.model.Genre;
import com.example.movie_rest_api.repository.GenreRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class GenreService {
	
	@Autowired
	private GenreRepository gr;
	
	public Genre saveGenre(Genre genre) {
		Genre res=gr.save(genre);
		return res;
	}
	
	public Genre getGenre(Long id) {
		return gr.findById(id)
				.orElseThrow(() -> new RuntimeException("Genre not found"));
	}

	public List<Genre> findAllGenre() {
		return gr.findAll();
		
	}
	

}
