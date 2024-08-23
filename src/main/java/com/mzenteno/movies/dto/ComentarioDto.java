package com.mzenteno.movies.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class ComentarioDto {

  @Data
  @Builder
  @AllArgsConstructor
  public static class ComentarioListDTO {
    private Long idComentario;
    private Long idUsuario;
    private Long idPelicula;
    private String tituloPelicula;
    private LocalDateTime fecha;
    private String descripcion;
    private Integer meGusta;
    private Integer noMeGusta;    
  }  

  @Data
  @Builder
  @AllArgsConstructor
  public static class ComentarioPeliculaListDTO {
    private Long idComentario;
    private LocalDateTime fecha;
    private String descripcion;
    private Integer meGusta;
    private Integer noMeGusta;    
  }
  
}
