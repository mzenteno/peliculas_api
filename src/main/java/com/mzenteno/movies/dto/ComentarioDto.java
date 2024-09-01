package com.mzenteno.movies.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ComentarioDto {

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class DTO {
    private Long idComentario;
    private Long idUsuario;
    private Long idPelicula;
    private LocalDateTime fecha;
    private String descripcion;
    private Integer meGusta;
    private Integer noMeGusta;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class CreateDTO {
    @NotNull(message = "El IdUsuario es obligatorio")
    @Min(value = 1, message = "El valor debe ser mayor que 0")
    private Long idUsuario;

    @NotNull(message = "El IdPelicula es obligatorio")
    @Min(value = 1, message = "El valor debe ser mayor que 0")
    private Long idPelicula;

    @NotNull(message = "La descripción es obligatoria")
    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 900, message = "La descripción debe tener al menos 12 caracteres.")
    private String descripcion;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class ListDTO {
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
  @NoArgsConstructor
  public static class PeliculaListDTO {
    private Long idComentario;
    private LocalDateTime fecha;
    private String descripcion;
    private Integer meGusta;
    private Integer noMeGusta;
  }

}