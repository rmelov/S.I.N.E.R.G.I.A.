package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.EmailDiscente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDiscenteRepositorio extends JpaRepository<EmailDiscente, Integer>{
    
}