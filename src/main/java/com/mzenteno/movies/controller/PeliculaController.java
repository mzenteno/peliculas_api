package com.mzenteno.movies.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzenteno.movies.dto.ComentarioDto;
import com.mzenteno.movies.dto.PeliculaDto;
import com.mzenteno.movies.service.ComentarioService;
import com.mzenteno.movies.service.PeliculaService;

@RestController
@RequestMapping("/api/v1/peliculas")
public class PeliculaController {
  private final PeliculaService peliculaService;
  private final ComentarioService comentarioService;

  public PeliculaController(PeliculaService peliculaService, ComentarioService comentarioService) {
    this.peliculaService = peliculaService;
    this.comentarioService = comentarioService;
  }

  @GetMapping("/{idPelicula}")  
  public ResponseEntity<PeliculaDto.DTO> findById(@PathVariable Long idPelicula) {
    PeliculaDto.DTO pelicula = peliculaService.findById(idPelicula);
    return ResponseEntity.ok(pelicula);
  }

  @GetMapping("/estrenos")
  public ResponseEntity<List<PeliculaDto.EstrenoListDTO>> finAllPeliculaEstreno() {
    List<PeliculaDto.EstrenoListDTO> peliculas = peliculaService.findAllPeliculaEstreno();
    return ResponseEntity.ok(peliculas);
  }

  @GetMapping("/{idPelicula}/comentarios")
  public ResponseEntity<List<ComentarioDto.PeliculaListDTO>> findAllComentariosByIdPelicula(@PathVariable Long idPelicula){
    List<ComentarioDto.PeliculaListDTO> comentarios = comentarioService.findAllByIdPelicula(idPelicula);
    return ResponseEntity.ok(comentarios);
  }

}