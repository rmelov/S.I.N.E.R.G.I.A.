package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.RedeProjeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedeProjetoRepositorio extends JpaRepository<RedeProjeto, Integer>{
    
}