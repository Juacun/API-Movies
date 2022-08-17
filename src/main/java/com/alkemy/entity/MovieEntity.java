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

@Getter
@Setter
@Entity
@Table(name = "movies")
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

	
	public void addCharacter(CharacterEntity character) {this.associatedCharacters.add(character);}
	
	public void removeCharacter(CharacterEntity character) {this.associatedCharacters.remove(character);}
	
	public void addGenre (GenreEntity genre) {this.associatedGenres.add(genre);}
	
	public void removeGenre (GenreEntity genre) {this.associatedGenres.remove(genre);}
	
}