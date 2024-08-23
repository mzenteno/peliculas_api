package com.mzenteno.movies.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzenteno.movies.dto.ComentarioDto;
import com.mzenteno.movies.service.ComentarioService;

@RestController
@RequestMapping("api/v1/comentarios")
public class ComentarioController {
  private final ComentarioService comentarioService;

  public ComentarioController(ComentarioService comentarioService) {
    this.comentarioService = comentarioService;
  }

  @GetMapping
  public ResponseEntity<List<ComentarioDto.ComentarioListDTO>> findAll() {
    List<ComentarioDto.ComentarioListDTO> comentarios = comentarioService.findAll();
    return ResponseEntity.ok(comentarios);
  }

  @GetMapping("/pelicula/{idPelicula}")
  public ResponseEntity<List<ComentarioDto.ComentarioPeliculaListDTO>> findAllByIdPelicula(@PathVariable Long idPelicula) {
    List<ComentarioDto.ComentarioPeliculaListDTO> comentarios = comentarioService.findAllByIdPelicula(idPelicula);
    return ResponseEntity.ok(comentarios);
  }
  
}