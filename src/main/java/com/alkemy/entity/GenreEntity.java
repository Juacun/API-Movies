package com.alkemy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "genres")
public class GenreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String image;
	
	private String name;
	
	@ManyToMany(mappedBy = "associatedGenres", cascade = CascadeType.ALL)
	private List<MovieEntity> associatedMovies = new ArrayList<>();

}