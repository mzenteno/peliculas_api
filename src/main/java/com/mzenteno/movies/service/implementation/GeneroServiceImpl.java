package com.mzenteno.movies.service.implementation;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mzenteno.movies.dto.GeneroDto;
//import com.mzenteno.movies.entity.Genero;
import com.mzenteno.movies.repository.GeneroRepository;
import com.mzenteno.movies.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroServiceImpl(GeneroRepository generoRepository) {
      this.generoRepository = generoRepository;
    }

    @Override
    public List<GeneroDto> getAllGenero() {
        //List<GeneroDto> generos = generoRepository.findAll();
        //return generos.stream().map((genero) -> GeneroMapper.mapToGeneroDto(genero)).collect(Collectors.toList());
        return null;
    }

}