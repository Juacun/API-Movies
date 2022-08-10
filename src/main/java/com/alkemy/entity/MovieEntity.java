package com.alkemy.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movies")
@Getter
@Setter
@SQLDelete(sql = "UPDATE movies SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String image;
	
	private String title;
	
	@Column(name = "date_creation")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate dateCreation;
	
	private int score;
	
	@ManyToMany(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(
			name = "characters_movies",
			joinColumns = @JoinColumn(name = "movies_id"),
			inverseJoinColumns = @JoinColumn(name = "characters_id"))
	private List<CharacterEntity> associatedCharacters = new ArrayList<>();

	@ManyToMany(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(
			name = "genres_movies",
			joinColumns = @JoinColumn(name = "movies_id"),
			inverseJoinColumns = @JoinColumn(name = "genres_id"))
	private List<GenreEntity> associatedGenres = new ArrayList<>();
	
	private boolean deleted = Boolean.FALSE;
	
	
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

	public List<CharacterEntity> getAssociatedCharacters() {
		return associatedCharacters;
	}

	public void setAssociatedCharacters(List<CharacterEntity> associatedCharacters) {
		this.associatedCharacters = associatedCharacters;
	}
	
	public List<GenreEntity> getAssociatedGenres() {
		return associatedGenres;
	}

	public void setAssociatedGenres(List<GenreEntity> associatedGenres) {
		this.associatedGenres = associatedGenres;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	
	public void addCharacter(CharacterEntity character) {this.associatedCharacters.add(character);}
	
	public void removeCharacter(CharacterEntity character) {this.associatedCharacters.remove(character);}
	
	public void addGenre (GenreEntity genre) {this.associatedGenres.add(genre);}
	
	public void removeGenre (GenreEntity genre) {this.associatedGenres.remove(genre);}
	
}