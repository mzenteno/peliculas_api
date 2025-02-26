package com.mzenteno.movies.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mzenteno.movies.dto.ComentarioDto;
import com.mzenteno.movies.service.ComentarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/comentarios")
public class ComentarioController {
  private final ComentarioService comentarioService;

  public ComentarioController(ComentarioService comentarioService) {
    this.comentarioService = comentarioService;
  }

  @PostMapping("/create")
  public ResponseEntity<ComentarioDto.DTO> create(@Valid @RequestBody ComentarioDto.CreateDTO comentarioCreateDTO){
    ComentarioDto.DTO nuevoComentarioDTO = comentarioService.create(comentarioCreateDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevoComentarioDTO);
  }

  @GetMapping
  public ResponseEntity<List<ComentarioDto.ListDTO>> findAll() {
    List<ComentarioDto.ListDTO> comentarios = comentarioService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(comentarios);
  }

  @GetMapping("/peliculas/{idPelicula}")
  public ResponseEntity<List<ComentarioDto.PeliculaListDTO>> findAllByIdPelicula(@Valid @PathVariable Long idPelicula) {
    List<ComentarioDto.PeliculaListDTO> comentarios = comentarioService.findAllByIdPelicula(idPelicula);
    return ResponseEntity.status(HttpStatus.OK).body(comentarios);
  }

  @PutMapping("/{idComentario}/adicionar-me-gusta")
  public ResponseEntity<ComentarioDto.DTO> addMeGusta(@Valid @PathVariable Long idComentario) {
    ComentarioDto.DTO comentario = comentarioService.addMeGusta(idComentario);
    return ResponseEntity.status(HttpStatus.OK).body(comentario);
  }

  @PutMapping("/{idComentario}/adicionar-no-me-gusta")
  public ResponseEntity<ComentarioDto.DTO> addNoMeGusta(@Valid @PathVariable Long idComentario) {
    ComentarioDto.DTO comentario = comentarioService.addNoMeGusta(idComentario);
    return ResponseEntity.status(HttpStatus.OK).body(comentario);
  }
  
}