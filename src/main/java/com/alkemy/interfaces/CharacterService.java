package com.alkemy.interfaces;

import java.util.List;
import java.util.Set;

import com.alkemy.modelDTO.CharacterDTO;

public interface CharacterService {

	public CharacterDTO getCharacterById(Long id, boolean loadAssociatedMovies);
	
	public List<CharacterDTO> getAllCharacter(boolean loadAssociatedMovies);
	
	public List<CharacterDTO> getCharacterByFilters(String name, String age, String weight, Set<Long> movies);
	
	public CharacterDTO saveCharacter(CharacterDTO characterDTO, boolean loadAssociatedMovies);
	
	public CharacterDTO updateCharacter(Long id, CharacterDTO characterDTO, boolean loadAssociatedMovies);
	
	public void deleteCharacterById(Long id);
}