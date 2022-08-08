package com.alkemy.modelMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.entity.CharacterEntity;
import com.alkemy.modelDTO.CharacterDTO;

@Component
public class CharacterMapper {

	public CharacterEntity characterDTO2Entity(CharacterDTO characterDTO) {
		
		CharacterEntity characterEntity = new CharacterEntity();
		
		characterEntity.setId(characterDTO.getId());
		characterEntity.setImage(characterDTO.getImage());
		characterEntity.setName(characterDTO.getName());
		characterEntity.setAge(characterDTO.getAge());
		characterEntity.setWeight(characterDTO.getWeight());
		characterEntity.setHistory(characterDTO.getHistory());
		characterEntity.setAssociatedMovies(characterDTO.getAssociatedMovies());
		
		return characterEntity;
	}
	
	public CharacterDTO characterEntity2DTO(CharacterEntity characterEntity) {
		
		CharacterDTO characterDTO = new CharacterDTO();
		
		characterDTO.setId(characterEntity.getId());
		characterDTO.setImage(characterEntity.getImage());
		characterDTO.setName(characterEntity.getName());
		characterDTO.setAge(characterEntity.getAge());
		characterDTO.setWeight(characterEntity.getWeight());
		characterDTO.setHistory(characterEntity.getHistory());
		characterDTO.setAssociatedMovies(characterEntity.getAssociatedMovies());
		
		return characterDTO;
	}
	
	public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> characterEntityList) {
		
		List<CharacterDTO> characterDTOList = new ArrayList<>();
		for (CharacterEntity entity : characterEntityList) {
			characterDTOList.add(characterEntity2DTO(entity));
		}
		
		return characterDTOList;
	}
}