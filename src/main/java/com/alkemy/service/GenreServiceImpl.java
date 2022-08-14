package com.alkemy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.entity.GenreEntity;
import com.alkemy.exception.ParamNotFound;
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
	public GenreDTO getGenreById(Long id, boolean loadAssociatedMovies) {
		
		Optional<GenreEntity> genreEntity = genreRepository.findById(id);
		
		if (genreEntity.isEmpty()) {
			throw new ParamNotFound("Id Movie not valid or Movie not exist!");
		}
		
		GenreDTO result = genreMapper.genreEntity2DTO(genreEntity.get(), loadAssociatedMovies);
		return result;
	}

	@Override
	public List<GenreDTO> getAllGenre(boolean loadAssociatedMovies) {
		
		List<GenreEntity> genreEntityList = genreRepository.findAll();
		List<GenreDTO> result = genreMapper.genreEntityList2DTOList(genreEntityList, loadAssociatedMovies);
		return result;
	}

	@Override
	public GenreDTO saveGenre(GenreDTO genreDTO, boolean loadAssociatedMovies) {
		
		GenreEntity genreEntity = genreMapper.genreDTO2Entity(genreDTO, true);
		GenreEntity genreEntitySaved = genreRepository.save(genreEntity);
		GenreDTO result = genreMapper.genreEntity2DTO(genreEntitySaved, loadAssociatedMovies);
		return result;
	}

	@Override
	public GenreDTO updateGenre(Long id, GenreDTO genreDTO, boolean loadAssociatedMovies) {
		
		genreDTO.setId(id);
		return saveGenre(genreDTO, loadAssociatedMovies);
	}

	@Override
	public void deleteGenreById(Long id) {
		
		genreRepository.deleteById(id);
	}
	
}