package com.alkemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.interfaces.GenreService;
import com.alkemy.modelDTO.GenreDTO;

@RestController
@RequestMapping("genres")
public class GenreController {

	@Autowired
	GenreService genreService;
	
	@GetMapping
	public ResponseEntity<List<GenreDTO>> getAll() {
		
		List<GenreDTO> genreDTOList = genreService.getAllGenre(true);
		return ResponseEntity.status(HttpStatus.OK).body(genreDTOList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GenreDTO> getById(@PathVariable Long id) {
		
		GenreDTO genreDTO = genreService.getGenreById(id, true);
		return ResponseEntity.status(HttpStatus.OK).body(genreDTO);
	}
	
	@PostMapping
	public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genreDTO) {
		
		GenreDTO genreDTOSaved = genreService.saveGenre(genreDTO, true);
		return ResponseEntity.status(HttpStatus.CREATED).body(genreDTOSaved);
	}
}