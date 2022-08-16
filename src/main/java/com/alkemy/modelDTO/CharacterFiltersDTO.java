package com.alkemy.modelDTO;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterFiltersDTO {

	private String name;
	
	private String age;
	
	private String weight;
	
	private Set<Long> movies;
	
	public CharacterFiltersDTO(String name, String age, String weight, Set<Long> movies) {
		
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.movies = movies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Set<Long> getMovies() {
		return movies;
	}

	public void setMovies(Set<Long> movies) {
		this.movies = movies;
	}
	
}