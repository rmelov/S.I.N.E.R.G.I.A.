package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.StatusProjeto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusProjetoRepositorio extends JpaRepository<StatusProjeto, Integer> {

    Optional<StatusProjeto> findByDescricao(String descricao);

}