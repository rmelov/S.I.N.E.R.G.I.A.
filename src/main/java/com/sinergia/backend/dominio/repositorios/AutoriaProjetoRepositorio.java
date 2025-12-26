package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.AutoriaProjeto;
import com.sinergia.backend.dominio.modelos.Projeto;
import com.sinergia.backend.dominio.modelos.Discente;
import com.sinergia.backend.dominio.modelos.OrdemAutoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoriaProjetoRepositorio extends JpaRepository<AutoriaProjeto, Integer>{

    boolean existsByProjetoAndDiscenteAndOrdemAutoria(Projeto projeto, Discente discente, OrdemAutoria ordemAutoria);

    List<AutoriaProjeto> findByProjetoAndDiscente(Projeto p, Discente d);

}
