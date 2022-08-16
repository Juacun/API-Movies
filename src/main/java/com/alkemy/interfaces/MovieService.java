package com.alkemy.interfaces;

import java.util.List;
import java.util.Set;

import com.alkemy.modelDTO.MovieDTO;

public interface MovieService {

	public MovieDTO getMovieById(Long id, boolean loadAssociatedCharacters, boolean loadAssociatedGenres);
	
	public List<MovieDTO> getAllMovie(boolean loadAssociatedCharacters, boolean loadAssociatedGenres);
	
	public List<MovieDTO> getMovieByFilters(String title, Set<Long> genres, String order);

	public MovieDTO saveMovie(MovieDTO movieDTO, boolean loadAssociatedCharacters, boolean loadAssociatedGenres);
	
	public MovieDTO updateMovie(Long id, MovieDTO movieDTO, boolean loadAssociatedCharacters, boolean loadAssociatedGenres);
	
	public void deleteMovieById(Long id);
	
	public MovieDTO addCharacter2Movie(Long idMovie, Long idCharacter);
	
	public MovieDTO removeCharacter2Movie(Long idMovie, Long idCharacter);
	
	public MovieDTO addGenre2Movie(Long idMovie, Long idGenre);
	
	public MovieDTO removeGenre2Movie(Long idMovie, Long idGenre);
}