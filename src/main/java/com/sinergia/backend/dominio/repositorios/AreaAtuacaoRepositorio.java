package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.AreaAtuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AreaAtuacaoRepositorio extends JpaRepository<AreaAtuacao, Integer> {

    Optional<AreaAtuacao> findByDescricaoIgnoreCase(String descricao);

    boolean existsByDescricaoIgnoreCase(String descricao);

}