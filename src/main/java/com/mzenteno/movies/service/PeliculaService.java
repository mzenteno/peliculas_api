package com.mzenteno.movies.service;

import java.util.List;
import com.mzenteno.movies.dto.PeliculaDto;

public interface PeliculaService {

  List<PeliculaDto.PeliculaEstrenoListDTO> findAllPeliculaEstreno();

  PeliculaDto.PeliculaDTO findById(Long id);
  
}
