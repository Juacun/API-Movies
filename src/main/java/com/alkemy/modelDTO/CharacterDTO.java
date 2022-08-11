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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public List<MovieDTO> getAssociatedMovies() {
		return associatedMovies;
	}

	public void setAssociatedMovies(List<MovieDTO> associatedMovies) {
		this.associatedMovies = associatedMovies;
	}
	
}