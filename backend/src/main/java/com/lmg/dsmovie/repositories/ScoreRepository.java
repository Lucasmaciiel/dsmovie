package com.lmg.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmg.dsmovie.entities.Score;
import com.lmg.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
	

}
