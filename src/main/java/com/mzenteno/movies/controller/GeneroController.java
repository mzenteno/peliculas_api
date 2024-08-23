package com.mzenteno.movies.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzenteno.movies.dto.GeneroDto;
import com.mzenteno.movies.service.GeneroService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/generos")
public class GeneroController {
    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
      this.generoService = generoService;
    }

    @GetMapping
    public ResponseEntity<List<GeneroDto>> getAllGenero() {
        List<GeneroDto> generos = generoService.getAllGenero();
        return ResponseEntity.ok(generos);
    }
}