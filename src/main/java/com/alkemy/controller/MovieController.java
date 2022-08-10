package com.alkemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.interfaces.CharacterService;
import com.alkemy.interfaces.MovieService;
import com.alkemy.modelDTO.MovieDTO;

@RestController
@RequestMapping("movies")
public class MovieController {

	MovieService movieService;
	CharacterService characterService;
	
	@Autowired
	public MovieController(MovieService movieService, CharacterService characterService) {
		
		this.movieService = movieService;
		this.characterService = characterService;
	}
	
	@GetMapping
	public ResponseEntity<List<MovieDTO>> getAll() {
		
		List<MovieDTO> movieDTOList = movieService.getAllMovie();
		return ResponseEntity.status(HttpStatus.OK).body(movieDTOList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> getById(@PathVariable Long id) {
		
		MovieDTO movieDTO = movieService.getMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTO);
	}
	
	@PostMapping
	public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDTO) {
		
		MovieDTO movieDTOSaved = movieService.saveMovie(movieDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(movieDTOSaved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
		
		MovieDTO movieDTOUpdated = movieService.updateMovie(id, movieDTO);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTOUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		movieService.deleteMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PostMapping("/{id}/characters/{idCharacter}")
	public ResponseEntity<Void> addCharacter(@PathVariable Long id, @PathVariable Long idCharacter) {
		
		// TODO add Character to Movie
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/{id}/characters/{idCharacter}")
	public ResponseEntity<Void> removePais(@PathVariable Long id, @PathVariable Long idCharacter) {
		
		// TODO remove Character from Movie
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PostMapping("/{id}/genres/{idGenre}")
	public ResponseEntity<Void> addGenre(@PathVariable Long id, @PathVariable Long idGenre) {
		
		// TODO add Genre to Movie
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/{id}/genres/{idGenre}")
	public ResponseEntity<Void> removeGenre(@PathVariable Long id, @PathVariable Long idGenre) {
		
		// TODO remove Genre from Movie
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}