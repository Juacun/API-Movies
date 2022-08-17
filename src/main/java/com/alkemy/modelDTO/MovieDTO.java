package com.alkemy.modelDTO;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {

	private Long id;
	
	private String image;
	
	private String title;
	
	private LocalDate dateCreation;
	
	private int score;
	
	private List<CharacterDTO> associatedCharacters;

	private List<GenreDTO> associatedGenres;

}