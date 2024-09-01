package com.mzenteno.movies.service;

import java.util.List;
import com.mzenteno.movies.dto.ComentarioDto;

public interface ComentarioService {
  
  List<ComentarioDto.ListDTO> findAll();

  List<ComentarioDto.PeliculaListDTO> findAllByIdPelicula(Long idPelicula);

  ComentarioDto.DTO create(ComentarioDto.CreateDTO dto);

}