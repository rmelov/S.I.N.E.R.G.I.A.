package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.AreaAtuacaoProjeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaAtuacaoProjetoRepositorio extends JpaRepository<AreaAtuacaoProjeto, Integer>{
    
}
