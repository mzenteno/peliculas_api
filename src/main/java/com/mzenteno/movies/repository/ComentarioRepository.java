package com.mzenteno.movies.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mzenteno.movies.entity.Comentario;

import jakarta.transaction.Transactional;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
  
  List<Comentario> findByPeliculaIdPeliculaOrderByFechaDesc(Long idPelicula);

  @Modifying
  @Transactional
  @Query(value = "UPDATE comentarios SET me_gusta=me_gusta+1 WHERE id_comentario=:idComentario", nativeQuery = true)
  void addMeGusta(Long idComentario);

  @Modifying
  @Transactional
  @Query(value = "UPDATE comentarios SET no_me_gusta=no_me_gusta+1 WHERE id_comentario=:idComentario", nativeQuery = true)
  void addNoMeGusta(Long idComentario);

}
