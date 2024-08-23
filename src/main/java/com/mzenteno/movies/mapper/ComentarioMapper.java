package com.mzenteno.movies.mapper;

import com.mzenteno.movies.dto.ComentarioDto;
import com.mzenteno.movies.entity.Comentario;

public class ComentarioMapper {
  
  public static ComentarioDto.ComentarioListDTO ComentarioList_ToDto(Comentario comentario){
    if (comentario == null) {
      return null;
    }

    ComentarioDto.ComentarioListDTO dto = new ComentarioDto.ComentarioListDTO(
      comentario.getIdComentario(),
      comentario.getIdUsuario(),
      comentario.getPelicula() != null ? comentario.getPelicula().getIdPelicula(): null,
      comentario.getPelicula() != null ? comentario.getPelicula().getTitulo() : null,
      comentario.getFecha(),
      comentario.getDescripcion(),
      comentario.getMeGusta(),
      comentario.getNoMeGusta()
    );

    return dto;
  }

  public static ComentarioDto.ComentarioPeliculaListDTO ComentarioPeliculaList_ToDto(Comentario comentario){
    if (comentario == null) {
      return null;
    }

    ComentarioDto.ComentarioPeliculaListDTO dto = new ComentarioDto.ComentarioPeliculaListDTO(
      comentario.getIdComentario(),
      comentario.getFecha(),
      comentario.getDescripcion(),
      comentario.getMeGusta(),
      comentario.getNoMeGusta()
    );

    return dto;
  }

}
