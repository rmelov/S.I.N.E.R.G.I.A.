package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.OrdemAutoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemAutoriaRepositorio extends JpaRepository<OrdemAutoria, Integer> {
    
}
