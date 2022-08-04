package com.alkemy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "genres")
@Getter
@Setter
public class GenreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String image;
	
	private String name;
	
	@ManyToMany(mappedBy = "associatedGenres", cascade = CascadeType.ALL)
	private List<MovieEntity> associatedMovies = new ArrayList<>();

	
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