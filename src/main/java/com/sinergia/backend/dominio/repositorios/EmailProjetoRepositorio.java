package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.EmailProjeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailProjetoRepositorio extends JpaRepository<EmailProjeto, Integer>{
    
}