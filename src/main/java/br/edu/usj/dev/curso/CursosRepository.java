package br.edu.usj.dev.curso;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CursosRepository extends CrudRepository<Cursos,Long> {
    
    List<Cursos> findAll();
    
}
