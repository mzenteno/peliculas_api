package com.mzenteno.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mzenteno.movies.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    
}