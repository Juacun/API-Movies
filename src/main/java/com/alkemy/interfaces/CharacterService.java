package com.alkemy.interfaces;

import java.util.List;

import com.alkemy.modelDTO.CharacterDTO;

public interface CharacterService {

	public CharacterDTO getCharacterById(Long id);
	
	public List<CharacterDTO> getAllCharacter();
	
	public CharacterDTO saveCharacter(CharacterDTO characterDTO);
	
	public CharacterDTO updateCharacter(Long id, CharacterDTO characterDTO);
	
	public void deleteCharacterById(Long id);
}