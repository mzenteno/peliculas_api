package com.mzenteno.movies.service.implementation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.mzenteno.movies.dto.PeliculaDto;
import com.mzenteno.movies.entity.Pelicula;
import com.mzenteno.movies.repository.PeliculaRepository;
import com.mzenteno.movies.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService {
  private final PeliculaRepository peliculaRepository;
  private final ModelMapper modelMapper;

  public PeliculaServiceImpl(PeliculaRepository peliculaRepository, ModelMapper modelMapper) {
    this.peliculaRepository = peliculaRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<PeliculaDto.EstrenoListDTO> findAllPeliculaEstreno(){
    List<Pelicula> peliculas = peliculaRepository.findAll();

    return peliculas.stream()
      .map(pelicula -> modelMapper.map(pelicula, PeliculaDto.EstrenoListDTO.class))
      .collect(Collectors.toList());
  }

  @Override
  public PeliculaDto.DTO findById(Long id) {
    Optional<Pelicula> peliculaOpt = peliculaRepository.findById(id);    

    if (peliculaOpt.isPresent()) {
      Pelicula pelicula = peliculaOpt.get();
      System.out.println("Si existe la pelicula");
      return modelMapper.map(pelicula, PeliculaDto.DTO.class);
    } else {
      System.out.println("No existe la pelicula");
      return null;
    }
  }

}