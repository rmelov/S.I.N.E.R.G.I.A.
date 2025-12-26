package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.modelos.Discente;
import com.sinergia.backend.dominio.repositorios.DiscenteRepositorio;
import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiscenteServico {

    @Autowired
    private DiscenteRepositorio repositorio;

    @Transactional
    public Discente salvar(Discente discente){

        if(!discente.getEmailInstitucional().trim().toLowerCase().endsWith("@fatec.sp.gov.br")){
            throw new RegraNegocioExcecao("E-mail não permitido; use o institucional.");
        }

        if(repositorio.existsByEmailInstitucional(discente.getEmailInstitucional())){
            throw new RegraNegocioExcecao("E-mail já está cadastrado.");
        }

        if(repositorio.existsByRa(discente.getRa())){
            throw new RegraNegocioExcecao("RA já está cadastrado.");
        }

        return repositorio.save(discente);

    }
    
}
