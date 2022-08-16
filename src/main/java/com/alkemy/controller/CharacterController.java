package com.alkemy.controller;

import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.interfaces.CharacterService;
import com.alkemy.modelDTO.CharacterDTO;

@RestController
@RequestMapping("characters")
public class CharacterController {

	@Autowired
	CharacterService characterService;
	
	@GetMapping("/all")
	public ResponseEntity<List<CharacterDTO>> getAll() {
		
		List<CharacterDTO> characterDTOList = characterService.getAllCharacter(true);
		return ResponseEntity.status(HttpStatus.OK).body(characterDTOList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CharacterDTO> getById(@PathVariable Long id) {
		
		CharacterDTO characterDTO = characterService.getCharacterById(id, true);
		return ResponseEntity.status(HttpStatus.OK).body(characterDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<CharacterDTO>> getCharacterByFilters(
			@RequestParam(required = false)String name,
			@RequestParam(required = false)String age,
			@RequestParam(required = false)String weight,
			@RequestParam(required = false)Set<Long> movies
	) {
		
		List<CharacterDTO> characterDTOListFiltered = characterService.getCharacterByFilters(name, age, weight, movies);
		return ResponseEntity.status(HttpStatus.OK).body(characterDTOListFiltered);
	}
	
	@PostMapping
	public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO characterDTO) {
		
		CharacterDTO characterDTOSaved = characterService.saveCharacter(characterDTO, true);
		return ResponseEntity.status(HttpStatus.CREATED).body(characterDTOSaved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CharacterDTO> update(@PathVariable Long id, @RequestBody CharacterDTO characterDTO) {
		
		CharacterDTO characterDTOUpdated = characterService.updateCharacter(id, characterDTO, true);
		return ResponseEntity.status(HttpStatus.OK).body(characterDTOUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		
		characterService.deleteCharacterById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Character with id: " + id + " was deleted!");
	}
	
}