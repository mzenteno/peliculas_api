package com.mzenteno.movies.service.implementation;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.mzenteno.movies.dto.ComentarioDto;
import com.mzenteno.movies.entity.Comentario;
import com.mzenteno.movies.mapper.ComentarioMapper;
import com.mzenteno.movies.repository.ComentarioRepository;
import com.mzenteno.movies.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {
  private final ComentarioRepository comentarioRepository;

  public ComentarioServiceImpl(ComentarioRepository comentarioRepository) {
    this.comentarioRepository = comentarioRepository;
  }

  @Override
  public List<ComentarioDto.ComentarioListDTO> findAll(){
    List<Comentario> comentarios = comentarioRepository.findAll();

    return comentarios.stream()
      .map((comentario) -> ComentarioMapper.ComentarioList_ToDto(comentario))
      .collect(Collectors.toList());
  }

  @Override
  public List<ComentarioDto.ComentarioPeliculaListDTO> findAllByIdPelicula(Long idPelicula) {
    List<Comentario> comentarios = comentarioRepository.findByPelicula_IdPelicula(idPelicula);

      return comentarios.stream()
      .map((comentario) -> ComentarioMapper.ComentarioPeliculaList_ToDto(comentario))
      .collect(Collectors.toList());
  }

}
