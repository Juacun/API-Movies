package com.alkemy.modelMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.entity.MovieEntity;
import com.alkemy.modelDTO.MovieDTO;

@Component
public class MovieMapper {

	public MovieEntity movieDTO2Entity(MovieDTO movieDTO) {
		
		MovieEntity movieEntity = new MovieEntity();
		
		movieEntity.setId(movieDTO.getId());
		movieEntity.setImage(movieDTO.getImage());
		movieEntity.setTitle(movieDTO.getTitle());
		movieEntity.setDateCreation(movieDTO.getDateCreation());
		movieEntity.setScore(movieDTO.getScore());
		movieEntity.setAssociatedCharacters(movieDTO.getAssociatedCharacters());
		movieEntity.setAssociatedGenres(movieDTO.getAssociatedGenres());
		
		return movieEntity;
	}
	
	public MovieDTO movieEntity2DTO(MovieEntity movieEntity) {
		
		MovieDTO movieDTO = new MovieDTO();
		
		movieDTO.setId(movieEntity.getId());
		movieDTO.setImage(movieEntity.getImage());
		movieDTO.setTitle(movieEntity.getTitle());
		movieDTO.setDateCreation(movieEntity.getDateCreation());
		movieDTO.setScore(movieEntity.getScore());
		movieDTO.setAssociatedCharacters(movieEntity.getAssociatedCharacters());
		movieDTO.setAssociatedGenres(movieEntity.getAssociatedGenres());
		
		return movieDTO;
	}
	
	public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> movieEntityList) {
		
		List<MovieDTO> movieDTOList = new ArrayList<>();
		for (MovieEntity entity : movieEntityList) {
			movieDTOList.add(this.movieEntity2DTO(entity));
		}
		
		return movieDTOList;
	}
}