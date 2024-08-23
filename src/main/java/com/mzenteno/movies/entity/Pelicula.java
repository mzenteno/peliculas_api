package com.mzenteno.movies.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "peliculas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Pelicula implements Serializable {

    @Id
    @Column(name = "id_pelicula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;

    @Column(name = "tipo")
    private char tipo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "ano_creacion")
    private Integer anoCreacion;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "puntos")
    private double puntos;

    @Column(name = "imagen_portada")
    private String imagenPortada;

    @Column(name = "trailer")
    private String trailer;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

}
