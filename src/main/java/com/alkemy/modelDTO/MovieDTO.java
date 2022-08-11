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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<CharacterDTO> getAssociatedCharacters() {
		return associatedCharacters;
	}

	public void setAssociatedCharacters(List<CharacterDTO> associatedCharacters) {
		this.associatedCharacters = associatedCharacters;
	}

	public List<GenreDTO> getAssociatedGenres() {
		return associatedGenres;
	}

	public void setAssociatedGenres(List<GenreDTO> associatedGenres) {
		this.associatedGenres = associatedGenres;
	}
	
}