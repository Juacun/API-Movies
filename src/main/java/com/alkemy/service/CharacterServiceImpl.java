package com.alkemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.entity.CharacterEntity;
import com.alkemy.interfaces.CharacterService;
import com.alkemy.modelDTO.CharacterDTO;
import com.alkemy.modelMapper.CharacterMapper;
import com.alkemy.repository.CharacterRepository;

@Service
public class CharacterServiceImpl implements CharacterService{

	CharacterRepository characterRepository;
	CharacterMapper characterMapper;
	
	@Autowired
	public CharacterServiceImpl(CharacterRepository characterRepository, CharacterMapper characterMapper) {
		
		this.characterRepository = characterRepository;
		this.characterMapper = characterMapper;
	}

	
	@Override
	public CharacterDTO getCharacterById(Long id) {
		
		CharacterEntity characterEntity = characterRepository.getReferenceById(id);
		CharacterDTO result = characterMapper.characterEntity2DTO(characterEntity, true);
		return result;
	}

	@Override
	public List<CharacterDTO> getAllCharacter() {
		
		List<CharacterEntity> characterEntityList = characterRepository.findAll();
		List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(characterEntityList, true);
		return result;
	}

	@Override
	public CharacterDTO saveCharacter(CharacterDTO characterDTO) {
		
		CharacterEntity characterEntity = characterMapper.characterDTO2Entity(characterDTO);
		CharacterEntity characterEntitySaved = characterRepository.save(characterEntity);
		CharacterDTO result = characterMapper.characterEntity2DTO(characterEntitySaved, true);
		return result;
	}

	@Override
	public CharacterDTO updateCharacter(Long id, CharacterDTO characterDTO) {
		
		characterDTO.setId(id);
		return saveCharacter(characterDTO);
	}

	@Override
	public void deleteCharacterById(Long id) {
		
		characterRepository.deleteById(id);
	}
	
}