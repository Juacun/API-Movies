package com.alkemy.modelDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterBasicDTO {

	private Long id;
	
	private String image;
	
	private String name;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}