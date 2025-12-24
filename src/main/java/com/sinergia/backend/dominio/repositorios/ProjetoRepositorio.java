package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepositorio extends JpaRepository<Projeto, Integer>{
    
}
