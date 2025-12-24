package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Integer>{
    
}
