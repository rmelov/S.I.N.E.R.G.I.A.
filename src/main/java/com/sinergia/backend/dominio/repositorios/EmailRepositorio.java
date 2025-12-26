package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepositorio extends JpaRepository<Email, Integer> {

}