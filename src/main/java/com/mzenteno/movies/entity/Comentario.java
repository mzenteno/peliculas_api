package com.mzenteno.movies.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comentarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comentario implements Serializable {

  @Id
  @Column(name = "id_comentario")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idComentario;

  @Column(name = "id_usuario")
  private Long idUsuario;

  @Column(name = "fecha")
  private LocalDateTime fecha;

  @Column(name = "descripcion")
  private String descripcion;

  @Column(name = "me_gusta")
  private Integer meGusta;

  @Column(name = "no_me_gusta")
  private Integer noMeGusta;

  @ManyToOne
  @JoinColumn(name = "id_pelicula")
  private Pelicula pelicula;

}
