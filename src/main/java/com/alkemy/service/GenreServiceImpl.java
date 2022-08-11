package com.alkemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.entity.GenreEntity;
import com.alkemy.interfaces.GenreService;
import com.alkemy.modelDTO.GenreDTO;
import com.alkemy.modelMapper.GenreMapper;
import com.alkemy.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService{
	
	GenreRepository genreRepository;
	GenreMapper genreMapper;
	
	@Autowired
	public GenreServiceImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
		
		this.genreRepository = genreRepository;
		this.genreMapper = genreMapper;
	}

	
	@Override
	public GenreDTO getGenreById(Long id) {
		
		GenreEntity genreEntity = genreRepository.getReferenceById(id);
		GenreDTO result = genreMapper.genreEntity2DTO(genreEntity, true);
		return result;
	}

	@Override
	public List<GenreDTO> getAllGenre() {
		
		List<GenreEntity> genreEntityList = genreRepository.findAll();
		List<GenreDTO> result = genreMapper.genreEntityList2DTOList(genreEntityList, true);
		return result;
	}

	@Override
	public GenreDTO saveGenre(GenreDTO genreDTO) {
		
		GenreEntity genreEntity = genreMapper.genreDTO2Entity(genreDTO);
		GenreEntity genreEntitySaved = genreRepository.save(genreEntity);
		GenreDTO result = genreMapper.genreEntity2DTO(genreEntitySaved, true);
		return result;
	}

	@Override
	public GenreDTO updateGenre(Long id, GenreDTO genreDTO) {
		
		genreDTO.setId(id);
		return saveGenre(genreDTO);
	}

	@Override
	public void deleteGenreById(Long id) {
		
		genreRepository.deleteById(id);
	}
	
}