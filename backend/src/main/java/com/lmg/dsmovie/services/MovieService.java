package com.lmg.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lmg.dsmovie.dto.MovieDTO;
import com.lmg.dsmovie.entities.Movie;
import com.lmg.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		
		Page<Movie> movies = this.movieRepository.findAll(pageable);
		Page<MovieDTO> page = movies.map(x -> new MovieDTO(x));
		
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		var movie = this.movieRepository.findById(id).get();
		
		MovieDTO dto = new MovieDTO(movie);
		
		return dto;
	}
}
