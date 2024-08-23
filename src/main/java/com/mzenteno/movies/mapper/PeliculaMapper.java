package com.mzenteno.movies.mapper;

import com.mzenteno.movies.dto.PeliculaDto;
import com.mzenteno.movies.entity.Pelicula;

public class PeliculaMapper {

  public static PeliculaDto.PeliculaDTO Pelicula_ToDto(Pelicula pelicula) {
    if (pelicula == null) {
      return null;
    }

    PeliculaDto.PeliculaDTO dto = new PeliculaDto.PeliculaDTO(
      pelicula.getIdPelicula(),
      pelicula.getTipo(),
      pelicula.getTitulo(),
      pelicula.getDescripcion(),
      pelicula.getAnoCreacion(),
      pelicula.getDuracion(),
      pelicula.getPuntos(),
      pelicula.getImagenPortada(),
      pelicula.getTrailer()
    );
    return dto;
  } 
  
  public static PeliculaDto.PeliculaEstrenoListDTO PeliculaEstrenoList_ToDto(Pelicula pelicula) {
    if (pelicula == null) {
      return null;
    }

    PeliculaDto.PeliculaEstrenoListDTO dto = new PeliculaDto.PeliculaEstrenoListDTO(
      pelicula.getIdPelicula(),
      pelicula.getTitulo(),
      pelicula.getPuntos(),
      pelicula.getImagenPortada()
    );

    return dto;
  }

}