package com.mzenteno.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PeliculaDto {

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class DTO {
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
  @NoArgsConstructor
  public static class EstrenoListDTO {
    private Long idPelicula;
    private char tipo;
    private String titulo;
    private double puntos;
    private String imagenPortada;
  }
  
}
