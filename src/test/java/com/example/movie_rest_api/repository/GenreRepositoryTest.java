package com.example.movie_rest_api.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import com.example.movie_rest_api.model.Genre;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class GenreRepositoryTest {
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Test
	void testSaveAndFindById() {
		//Arrange
		Genre genre=new Genre();
		genre.setName("Comedy");

		//Act
		Genre savedGenre=genreRepository.save(genre);
		Optional<Genre> retrievedGenre= genreRepository.findById(savedGenre.getId());
		
		//Assert
		assertThat(retrievedGenre).isPresent();
		assertEquals("Comedy", retrievedGenre.get().getName());
	}

}
