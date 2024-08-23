package com.mzenteno.movies.service;

import java.util.List;
import com.mzenteno.movies.dto.ComentarioDto;

public interface ComentarioService {
  
  List<ComentarioDto.ComentarioListDTO> findAll();

  List<ComentarioDto.ComentarioPeliculaListDTO> findAllByIdPelicula(Long idPelicula);

}