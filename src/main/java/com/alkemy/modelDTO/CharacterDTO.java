package com.alkemy.modelDTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {

	private Long id;
	
	private String image;
	
	private String name;
	
	private int age;
	
	private float weight;
	
	private String history;
	
	private List<MovieDTO> associatedMovies;

}