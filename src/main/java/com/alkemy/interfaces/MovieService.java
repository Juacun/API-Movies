package com.alkemy.interfaces;

import java.util.List;

import com.alkemy.modelDTO.MovieDTO;

public interface MovieService {

	public MovieDTO getMovieById(Long id);
	
	public List<MovieDTO> getAllMovie();
	
	public MovieDTO saveMovie(MovieDTO movieDTO);
	
	public MovieDTO updateMovie(Long id, MovieDTO movieDTO);
	
	public void deleteMovieById(Long id);
}