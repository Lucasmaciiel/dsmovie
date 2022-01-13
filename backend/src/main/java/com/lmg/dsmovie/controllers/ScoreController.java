package com.lmg.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmg.dsmovie.dto.MovieDTO;
import com.lmg.dsmovie.dto.ScoreDTO;
import com.lmg.dsmovie.entities.Score;
import com.lmg.dsmovie.services.MovieService;
import com.lmg.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO) {
		 return scoreService.saveScore(scoreDTO);

	}
}
