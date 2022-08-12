package com.alkemy.interfaces;

import java.util.List;

import com.alkemy.modelDTO.GenreDTO;

public interface GenreService {

	public GenreDTO getGenreById(Long id, boolean loadAssociatedMovies);
	
	public List<GenreDTO> getAllGenre(boolean loadAssociatedMovies);
	
	public GenreDTO saveGenre(GenreDTO genreDTO, boolean loadAssociatedMovies);
	
	public GenreDTO updateGenre(Long id, GenreDTO genreDTO, boolean loadAssociatedMovies);
	
	public void deleteGenreById(Long id);
}