package com.alkemy.interfaces;

import java.util.List;

public interface GenreService {

	public GenreDTO getGenreById(Long id);
	
	public List<GenreDTO> getAllGenre();
	
	public GenreDTO saveGenre(GenreDTO genreDTO);
	
	public GenreDTO updateGenre(Long id, GenreDTO genreDTO);
	
	public void deleteGenreById(Long id);
}