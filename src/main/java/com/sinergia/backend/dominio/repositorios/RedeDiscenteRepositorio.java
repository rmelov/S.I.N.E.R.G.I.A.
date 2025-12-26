package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.RedeDiscente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedeDiscenteRepositorio extends JpaRepository<RedeDiscente, Integer>{
    
}
