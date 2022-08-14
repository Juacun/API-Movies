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
		
		List<MovieDTO> movieDTOList = movieService.getAllMovie(true, true);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTOList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> getById(@PathVariable Long id) {
		
		MovieDTO movieDTO = movieService.getMovieById(id, true, true);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTO);
	}
	
	@PostMapping
	public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movieDTO) {
		
		MovieDTO movieDTOSaved = movieService.saveMovie(movieDTO, true ,true);
		return ResponseEntity.status(HttpStatus.CREATED).body(movieDTOSaved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
		
		MovieDTO movieDTOUpdated = movieService.updateMovie(id, movieDTO, true ,true);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTOUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		
		movieService.deleteMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Movie with id: " + id + " was deleted!");
	}
	
	@PostMapping("/{idMovie}/characters/{idCharacter}")
	public ResponseEntity<MovieDTO> addCharacter(@PathVariable Long idMovie, @PathVariable Long idCharacter) {
		
		MovieDTO movieDTO = movieService.addCharacter2Movie(idMovie, idCharacter);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTO);
	}
	
	@DeleteMapping("/{idMovie}/characters/{idCharacter}")
	public ResponseEntity<MovieDTO> removeCharacter(@PathVariable Long idMovie, @PathVariable Long idCharacter) {
		
		MovieDTO movieDTO = movieService.removeCharacter2Movie(idMovie, idCharacter);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTO);
	}
	
	@PostMapping("/{idMovie}/genres/{idGenre}")
	public ResponseEntity<MovieDTO> addGenre(@PathVariable Long idMovie, @PathVariable Long idGenre) {
		
		MovieDTO movieDTO = movieService.addGenre2Movie(idMovie, idGenre);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTO);
	}
	
	@DeleteMapping("/{idMovie}/genres/{idGenre}")
	public ResponseEntity<MovieDTO> removeGenre(@PathVariable Long idMovie, @PathVariable Long idGenre) {
		
		MovieDTO movieDTO = movieService.removeGenre2Movie(idMovie, idGenre);
		return ResponseEntity.status(HttpStatus.OK).body(movieDTO);
	}
}