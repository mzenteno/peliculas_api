package com.mzenteno.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class PeliculaDto {

  @Data
  @Builder
  @AllArgsConstructor
  public static class PeliculaDTO {
    private Long idPelicula;
    private char tipo;
    private String titulo;
    private String descripcion;
    private Integer anoCreacion;
    private Integer duracion;
    private double puntos;
    private String imagenPortada;
    private String trailer;
  }

  @Data
  @Builder
  @AllArgsConstructor
  public static class PeliculaEstrenoListDTO {
    private Long idPelicula;
    private String titulo;
    private double puntos;
    private String imagenPortada;
  }
  
}
