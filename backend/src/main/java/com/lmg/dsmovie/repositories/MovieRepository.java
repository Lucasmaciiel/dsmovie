package com.lmg.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmg.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
