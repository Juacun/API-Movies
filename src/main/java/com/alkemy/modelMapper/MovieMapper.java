package com.alkemy.modelMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.entity.MovieEntity;
import com.alkemy.modelDTO.CharacterDTO;
import com.alkemy.modelDTO.GenreDTO;
import com.alkemy.modelDTO.MovieDTO;

@Component
public class MovieMapper {

	@Autowired
	CharacterMapper characterMapper;
	@Autowired
	GenreMapper genreMapper;
	
	public MovieEntity movieDTO2Entity(MovieDTO movieDTO) {
		
		MovieEntity movieEntity = new MovieEntity();
		
		movieEntity.setId(movieDTO.getId());
		movieEntity.setImage(movieDTO.getImage());
		movieEntity.setTitle(movieDTO.getTitle());
		movieEntity.setDateCreation(movieDTO.getDateCreation());
		movieEntity.setScore(movieDTO.getScore());
		//TODO movieEntity.setAssociatedCharacters(movieDTO.getAssociatedCharacters());
		//TODO movieEntity.setAssociatedGenres(movieDTO.getAssociatedGenres());
		
		return movieEntity;
	}
	
	public MovieDTO movieEntity2DTO(MovieEntity movieEntity, boolean loadAssociatedCharacters, boolean loadAssociatedGenres) {
		
		MovieDTO movieDTO = new MovieDTO();
		
		movieDTO.setId(movieEntity.getId());
		movieDTO.setImage(movieEntity.getImage());
		movieDTO.setTitle(movieEntity.getTitle());
		movieDTO.setDateCreation(movieEntity.getDateCreation());
		movieDTO.setScore(movieEntity.getScore());
		
		if(loadAssociatedCharacters) {
			List<CharacterDTO> charactersDTO = characterMapper.characterEntityList2DTOList(movieEntity.getAssociatedCharacters(), false);
			movieDTO.setAssociatedCharacters(charactersDTO);
		}
		
		if (loadAssociatedGenres) {
			List<GenreDTO> genresDTO = genreMapper.genreEntityList2DTOList(movieEntity.getAssociatedGenres(), false);
			movieDTO.setAssociatedGenres(genresDTO);
		}
		
		return movieDTO;
	}
	
	public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> movieEntityList, boolean loadAssociatedCharacters, boolean loadAssociatedGenres) {
		
		List<MovieDTO> movieDTOList = new ArrayList<>();
		for (MovieEntity entity : movieEntityList) {
			movieDTOList.add(this.movieEntity2DTO(entity, loadAssociatedCharacters, loadAssociatedGenres));
		}
		
		return movieDTOList;
	}
}