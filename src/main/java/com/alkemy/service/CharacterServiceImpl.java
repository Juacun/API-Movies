package com.alkemy.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.entity.CharacterEntity;
import com.alkemy.exception.ParamNotFound;
import com.alkemy.interfaces.CharacterService;
import com.alkemy.modelDTO.CharacterDTO;
import com.alkemy.modelDTO.CharacterFiltersDTO;
import com.alkemy.modelMapper.CharacterMapper;
import com.alkemy.repository.CharacterRepository;
import com.alkemy.repository.specification.CharacterSpecification;

@Service
public class CharacterServiceImpl implements CharacterService{

	CharacterSpecification characterSpecification;
	CharacterRepository characterRepository;
	CharacterMapper characterMapper;
	
	@Autowired
	public CharacterServiceImpl(CharacterSpecification characterSpecification, 
								CharacterRepository characterRepository, CharacterMapper characterMapper) {
		
		this.characterSpecification = characterSpecification;
		this.characterRepository = characterRepository;
		this.characterMapper = characterMapper;
	}

	
	@Override
	public CharacterDTO getCharacterById(Long id, boolean loadAssociatedMovies) {
		
		Optional<CharacterEntity> characterEntity = characterRepository.findById(id);
		
		if (characterEntity.isEmpty()) {
			throw new ParamNotFound("Id Character not valid or Character not exist!");
		}
		
		CharacterDTO result = characterMapper.characterEntity2DTO(characterEntity.get(), loadAssociatedMovies);
		return result;
	}

	@Override
	public List<CharacterDTO> getAllCharacter(boolean loadAssociatedMovies) {
		
		List<CharacterEntity> characterEntityList = characterRepository.findAll();
		List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(characterEntityList, loadAssociatedMovies);
		return result;
	}

	@Override
	public List<CharacterDTO> getCharacterByFilters(String name, String age, String weight, Set<Long> movies) {
		
		CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, weight, movies);
		List<CharacterEntity> characterEntityListFiltered = characterRepository.findAll(characterSpecification.getByFilters(filtersDTO));
		List<CharacterDTO> characterDTOListFiltered = characterMapper.characterEntityList2DTOList(characterEntityListFiltered, true);
		return characterDTOListFiltered;
	}
	
	@Override
	public CharacterDTO saveCharacter(CharacterDTO characterDTO, boolean loadAssociatedMovies) {
		
		CharacterEntity characterEntity = characterMapper.characterDTO2Entity(characterDTO, true);
		CharacterEntity characterEntitySaved = characterRepository.save(characterEntity);
		CharacterDTO result = characterMapper.characterEntity2DTO(characterEntitySaved, loadAssociatedMovies);
		return result;
	}

	@Override
	public CharacterDTO updateCharacter(Long id, CharacterDTO characterDTO, boolean loadAssociatedMovies) {
		
		characterDTO.setId(id);
		return saveCharacter(characterDTO, loadAssociatedMovies);
	}

	@Override
	public void deleteCharacterById(Long id) {
		
		characterRepository.deleteById(id);
	}

}