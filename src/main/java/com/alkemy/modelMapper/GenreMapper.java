package com.alkemy.modelMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.entity.GenreEntity;
import com.alkemy.modelDTO.GenreDTO;
import com.alkemy.modelDTO.MovieDTO;

@Component
public class GenreMapper {

	@Autowired
	MovieMapper movieMapper;
	
	public GenreEntity genreDTO2Entity(GenreDTO genreDTO, boolean loadAssociatedMovies) {
		
		GenreEntity genreEntity = new GenreEntity();
		
		genreEntity.setId(genreDTO.getId());
		genreEntity.setImage(genreDTO.getImage());
		genreEntity.setName(genreDTO.getName());
		
			if (loadAssociatedMovies) {
				genreEntity.setAssociatedMovies(movieMapper.movieDTOList2EntityList(genreDTO.getAssociatedMovies(), false, false));
			}
		
		return genreEntity;
	}
	
	public GenreDTO genreEntity2DTO(GenreEntity genreEntity, boolean loadAssociatedMovies) {
		
		GenreDTO genreDTO = new GenreDTO();
		
		genreDTO.setId(genreEntity.getId());
		genreDTO.setImage(genreEntity.getImage());
		genreDTO.setName(genreEntity.getName());
		
		if (loadAssociatedMovies) {
			
			List<MovieDTO> moviesDTO = movieMapper.movieEntityList2DTOList(genreEntity.getAssociatedMovies(), false, false);
			genreDTO.setAssociatedMovies(moviesDTO);
		}
		
		return genreDTO;
	}
	
	public List<GenreDTO> genreEntityList2DTOList(List<GenreEntity> genreEntityList, boolean loadAssociatedMovies) {
		
		List<GenreDTO> genreDTOList = new ArrayList<>();
		for (GenreEntity entity : genreEntityList) {
			genreDTOList.add(this.genreEntity2DTO(entity, loadAssociatedMovies));
		}
		
		return genreDTOList;
	}
	
	public List<GenreEntity> genreDTOList2EntityList(List<GenreDTO> genreDTOList, boolean loadAssociatedMovies) {
		
		List<GenreEntity> genreEntityList = new ArrayList<>();
		for (GenreDTO dto : genreDTOList) {
			genreEntityList.add(this.genreDTO2Entity(dto, loadAssociatedMovies));
		}
		
		return genreEntityList;
	}
}