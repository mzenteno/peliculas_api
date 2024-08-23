package com.mzenteno.movies.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mzenteno.movies.entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

  List<Comentario> findByPelicula_IdPelicula(Long idPelicula);
  
} 
