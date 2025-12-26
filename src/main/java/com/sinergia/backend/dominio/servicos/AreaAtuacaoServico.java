package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import com.sinergia.backend.dominio.modelos.AreaAtuacao;
import com.sinergia.backend.dominio.repositorios.AreaAtuacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AreaAtuacaoServico {

    @Autowired
    private AreaAtuacaoRepositorio repositorio;

    @Transactional
    public AreaAtuacao salvar(AreaAtuacao area) {
       
        if (area.getDescricao() != null) {
            area.setDescricao(area.getDescricao().trim().toLowerCase());
        }

        repositorio.findByDescricaoIgnoreCase(area.getDescricao())
            .ifPresent(a -> { 
                throw new RegraNegocioExcecao("A área '" + area.getDescricao() + "' já existe."); 
            });
        
        return repositorio.save(area);
    }

    public List<AreaAtuacao> listarTodas() {
        return repositorio.findAll();
    }
}