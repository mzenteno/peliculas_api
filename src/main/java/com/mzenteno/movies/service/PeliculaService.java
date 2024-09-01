package com.mzenteno.movies.service;

import java.util.List;
import com.mzenteno.movies.dto.PeliculaDto;

public interface PeliculaService {

  List<PeliculaDto.EstrenoListDTO> findAllPeliculaEstreno();

  PeliculaDto.DTO findById(Long id);
  
}
