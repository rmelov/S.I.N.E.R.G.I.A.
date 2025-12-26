package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.TelefoneProjeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneProjetoRepositorio extends JpaRepository<TelefoneProjeto, Integer> {
    
}