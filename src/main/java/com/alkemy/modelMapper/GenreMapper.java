package com.alkemy.modelMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.entity.GenreEntity;
import com.alkemy.modelDTO.GenreDTO;

@Component
public class GenreMapper {

	public GenreEntity genreDTO2Entity(GenreDTO genreDTO) {
		
		GenreEntity genreEntity = new GenreEntity();
		
		genreEntity.setId(genreDTO.getId());
		genreEntity.setImage(genreDTO.getImage());
		genreEntity.setName(genreDTO.getName());
		genreEntity.setAssociatedMovies(genreDTO.getAssociatedMovies());
		
		return genreEntity;
	}
	
	public GenreDTO genreEntity2DTO(GenreEntity genreEntity) {
		
		GenreDTO genreDTO = new GenreDTO();
		
		genreDTO.setId(genreEntity.getId());
		genreDTO.setImage(genreEntity.getImage());
		genreDTO.setName(genreEntity.getName());
		genreDTO.setAssociatedMovies(genreEntity.getAssociatedMovies());
		
		return genreDTO;
	}
	
	public List<GenreDTO> genreEntityList2DTOList(List<GenreEntity> genreEntityList) {
		
		List<GenreDTO> genreDTOList = new ArrayList<>();
		for (GenreEntity entity : genreEntityList) {
			genreDTOList.add(this.genreEntity2DTO(entity));
		}
		
		return genreDTOList;
	}
}