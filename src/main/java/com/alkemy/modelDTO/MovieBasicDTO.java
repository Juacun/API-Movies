package com.alkemy.modelDTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieBasicDTO {

	private Long id;
	
	private String image;
	
	private String title;
	
	private LocalDate dateCreation;

}