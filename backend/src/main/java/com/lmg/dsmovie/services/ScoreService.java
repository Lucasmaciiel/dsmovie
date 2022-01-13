package com.lmg.dsmovie.services;

import java.util.Set;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lmg.dsmovie.dto.MovieDTO;
import com.lmg.dsmovie.dto.ScoreDTO;
import com.lmg.dsmovie.entities.Movie;
import com.lmg.dsmovie.entities.Score;
import com.lmg.dsmovie.entities.User;
import com.lmg.dsmovie.repositories.MovieRepository;
import com.lmg.dsmovie.repositories.ScoreRepository;
import com.lmg.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
			
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setUser(user);
		score.setMovie(movie);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}





}
