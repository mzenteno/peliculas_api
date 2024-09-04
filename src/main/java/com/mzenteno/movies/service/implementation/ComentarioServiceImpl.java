package com.mzenteno.movies.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.mzenteno.movies.dto.ComentarioDto;
import com.mzenteno.movies.dto.ComentarioDto.DTO;
import com.mzenteno.movies.entity.Comentario;
import com.mzenteno.movies.entity.Pelicula;
import com.mzenteno.movies.error.exception.InternalServerErrorException;
import com.mzenteno.movies.error.exception.ResourceNotFoundException;
import com.mzenteno.movies.repository.ComentarioRepository;
import com.mzenteno.movies.repository.PeliculaRepository;
import com.mzenteno.movies.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {
  private final ComentarioRepository comentarioRepository;
  private final PeliculaRepository peliculaRepository;
  private final ModelMapper modelMapper;

  public ComentarioServiceImpl(ComentarioRepository comentarioRepository, PeliculaRepository peliculaRepository, ModelMapper modelMapper) {
    this.comentarioRepository = comentarioRepository;
    this.peliculaRepository = peliculaRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public ComentarioDto.DTO create(ComentarioDto.CreateDTO dto) {
    if(!peliculaRepository.existsById(dto.getIdPelicula())) {
      throw new ResourceNotFoundException("Película con ID: " + dto.getIdPelicula() + " no encontrada");
    }
      
    try {
      Comentario comentario = modelMapper.map(dto, Comentario.class);
      comentario.setFecha(LocalDateTime.now());
      comentario.setMeGusta(0);
      comentario.setNoMeGusta(0);
  
      comentario = comentarioRepository.save(comentario);
      return modelMapper.map(comentario, ComentarioDto.DTO.class);
    } catch (Exception e) {
      throw new InternalServerErrorException("Error al crear el comentario");
    }
  }

  @Override
  public List<ComentarioDto.ListDTO> findAll(){
    List<Comentario> comentarios = comentarioRepository.findAll();

    return comentarios.stream()
      .map(comentario -> modelMapper.map(comentario, ComentarioDto.ListDTO.class))
      .collect(Collectors.toList());
  }

  @Override
  public List<ComentarioDto.PeliculaListDTO> findAllByIdPelicula(Long idPelicula) {
    if(!peliculaRepository.existsById(idPelicula)) {
      throw new ResourceNotFoundException("Película con ID: " + idPelicula + " no encontrada");
    }

    List<Comentario> comentarios = comentarioRepository.findByPeliculaIdPeliculaOrderByFechaDesc(idPelicula);
    return comentarios.stream()
      .map(comentario -> modelMapper.map(comentario, ComentarioDto.PeliculaListDTO.class))
      .collect(Collectors.toList());
  }

  @Override
  public ComentarioDto.DTO addMeGusta(Long idComentario) {
    if (!comentarioRepository.existsById(idComentario)) {
      throw new ResourceNotFoundException("Comentario con ID: " + idComentario + " no encontrado");
    }

    try {
      comentarioRepository.addMeGusta(idComentario);
      Comentario comentario = comentarioRepository.findById(idComentario).get();  
      return modelMapper.map(comentario, ComentarioDto.DTO.class);  
    } catch (Exception e) {
      throw new InternalServerErrorException("Error al dar like al comentario");
    }
  }

  @Override
  public DTO addNoMeGusta(Long idComentario) {
    if (!comentarioRepository.existsById(idComentario)) {
      throw new ResourceNotFoundException("Comentario con ID: " + idComentario + " no encontrado");
    }

    try {
      comentarioRepository.addNoMeGusta(idComentario);
      Comentario comentario = comentarioRepository.findById(idComentario).get();  
      return modelMapper.map(comentario, ComentarioDto.DTO.class);  
    } catch (Exception e) {
      throw new InternalServerErrorException("Error al dar like al comentario");
    }
  }

}