package com.alkemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.entity.MovieEntity;
import com.alkemy.interfaces.MovieService;
import com.alkemy.modelDTO.MovieDTO;
import com.alkemy.modelMapper.MovieMapper;
import com.alkemy.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	MovieRepository movieRepository;
	MovieMapper movieMapper;
	
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
		
	this.movieRepository = movieRepository;
	this.movieMapper = movieMapper;
	}
	
	
	@Override
	public MovieDTO getMovieById(Long id) {

		MovieEntity movieEntity  = movieRepository.getReferenceById(id);
		MovieDTO result = movieMapper.movieEntity2DTO(movieEntity, true, true);
		return result;
	}

	@Override
	public List<MovieDTO> getAllMovie() {

		List<MovieEntity> movieEntityList = movieRepository.findAll();
		List<MovieDTO> result = movieMapper.movieEntityList2DTOList(movieEntityList, true, true);
		return result;
	}

	@Override
	public MovieDTO saveMovie(MovieDTO movieDTO) {
		
		MovieEntity movieEntity = movieMapper.movieDTO2Entity(movieDTO);
		MovieEntity movieEntitySaved = movieRepository.save(movieEntity);
		MovieDTO result = movieMapper.movieEntity2DTO(movieEntitySaved, true, true);
		return result;
	}

	@Override
	public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
		
		movieDTO.setId(id);
		return saveMovie(movieDTO);
	}

	@Override
	public void deleteMovieById(Long id) {
		
		movieRepository.deleteById(id);
	}
	
}