package com.mzenteno.movies.mapper;

import com.mzenteno.movies.dto.GeneroDto;
import com.mzenteno.movies.entity.Genero;

public class GeneroMapper {

  public static Genero dtoToEntity(GeneroDto generoDto){
    if(generoDto == null){
      return null;
    }

    Genero entity = new Genero(
      generoDto.getIdGenero(),
      generoDto.getDescripcion()
    );

    return entity;
  }

  public static GeneroDto entityToDto(Genero genero){
    if( genero == null ){
      return null;
    }

    GeneroDto dto = new GeneroDto(
      genero.getIdGenero(),
      genero.getDescripcion()
    );

    return dto;
  }

}