package com.mzenteno.movies.service.implementation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.mzenteno.movies.dto.PeliculaDto;
import com.mzenteno.movies.entity.Pelicula;
import com.mzenteno.movies.mapper.PeliculaMapper;
import com.mzenteno.movies.repository.PeliculaRepository;
import com.mzenteno.movies.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService {
  private final PeliculaRepository peliculaRepository;

  public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
    this.peliculaRepository = peliculaRepository;
  }

  @Override
  public List<PeliculaDto.PeliculaEstrenoListDTO> findAllPeliculaEstreno(){
    List<Pelicula> peliculas = peliculaRepository.findAll();

    return peliculas.stream()
      .map((pelicula) -> PeliculaMapper.PeliculaEstrenoList_ToDto(pelicula))
      .collect(Collectors.toList());
  }

  @Override
  public PeliculaDto.PeliculaDTO findById(Long id) {
    Optional<Pelicula> pelicula = peliculaRepository.findById(id);

    if (pelicula.isPresent()) {
      return PeliculaMapper.Pelicula_ToDto(pelicula.get());
    } else {
      return null;
    }
  }

}