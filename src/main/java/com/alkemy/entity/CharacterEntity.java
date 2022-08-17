package com.alkemy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "characters")
@SQLDelete(sql = "UPDATE characters SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class CharacterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String image;
	
	private String name;
	
	private int age;
	
	private float weight;
	
	private String history;
	
	@ManyToMany(mappedBy = "associatedCharacters", cascade = CascadeType.REFRESH)
	private List<MovieEntity> associatedMovies = new ArrayList<>();

	private boolean deleted = Boolean.FALSE;

}