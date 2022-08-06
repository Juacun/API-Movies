package com.alkemy.modelDTO;

import java.util.List;

import com.alkemy.entity.MovieEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDTO {

	private Long id;
	
	private String image;
	
	private String name;
	
	private List<MovieEntity> associatedMovies;

	
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

	public List<MovieEntity> getAssociatedMovies() {
		return associatedMovies;
	}

	public void setAssociatedMovies(List<MovieEntity> associatedMovies) {
		this.associatedMovies = associatedMovies;
	}
	
}