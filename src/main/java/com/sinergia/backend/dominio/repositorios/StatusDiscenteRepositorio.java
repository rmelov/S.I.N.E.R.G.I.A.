package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.StatusDiscente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDiscenteRepositorio extends JpaRepository<StatusDiscente, Integer> {

}