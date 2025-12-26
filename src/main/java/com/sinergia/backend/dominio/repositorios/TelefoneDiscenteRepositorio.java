package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.TelefoneDiscente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneDiscenteRepositorio extends JpaRepository<TelefoneDiscente, Integer>{
    
}
