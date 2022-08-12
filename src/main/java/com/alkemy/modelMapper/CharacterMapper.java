package com.alkemy.modelMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.entity.CharacterEntity;
import com.alkemy.modelDTO.CharacterDTO;
import com.alkemy.modelDTO.MovieDTO;

@Component
public class CharacterMapper {

	@Autowired
	MovieMapper movieMapper;
	
	public CharacterEntity characterDTO2Entity(CharacterDTO characterDTO, boolean loadAssociatedMovies) {
		
		CharacterEntity characterEntity = new CharacterEntity();
		
		characterEntity.setId(characterDTO.getId());
		characterEntity.setImage(characterDTO.getImage());
		characterEntity.setName(characterDTO.getName());
		characterEntity.setAge(characterDTO.getAge());
		characterEntity.setWeight(characterDTO.getWeight());
		characterEntity.setHistory(characterDTO.getHistory());
		
		if (loadAssociatedMovies) {
			characterEntity.setAssociatedMovies(movieMapper.movieDTOList2EntityList(characterDTO.getAssociatedMovies(), false, true));
		}
		
		return characterEntity;
	}
	
	public CharacterDTO characterEntity2DTO(CharacterEntity characterEntity, boolean loadAssociatedMovies) {
		
		CharacterDTO characterDTO = new CharacterDTO();
		
		characterDTO.setId(characterEntity.getId());
		characterDTO.setImage(characterEntity.getImage());
		characterDTO.setName(characterEntity.getName());
		characterDTO.setAge(characterEntity.getAge());
		characterDTO.setWeight(characterEntity.getWeight());
		characterDTO.setHistory(characterEntity.getHistory());
		
		if (loadAssociatedMovies) {
			List<MovieDTO> moviesDTO = movieMapper.movieEntityList2DTOList(characterEntity.getAssociatedMovies(), false, true);
			characterDTO.setAssociatedMovies(moviesDTO);
		}
		
		return characterDTO;
	}
	
	public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> characterEntityList, boolean loadAssociatedMovies) {
		
		List<CharacterDTO> characterDTOList = new ArrayList<>();
		for (CharacterEntity entity : characterEntityList) {
			characterDTOList.add(characterEntity2DTO(entity, loadAssociatedMovies));
		}
		
		return characterDTOList;
	}
	
	public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> characterDTOList, boolean loadAssociatedMovies) {
		
		List<CharacterEntity> characterEntityList = new ArrayList<>();
		for (CharacterDTO dto : characterDTOList) {
			characterEntityList.add(characterDTO2Entity(dto, loadAssociatedMovies));
		}
		
		return characterEntityList;
	}
}