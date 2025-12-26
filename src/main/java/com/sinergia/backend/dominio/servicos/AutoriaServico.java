package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import com.sinergia.backend.dominio.modelos.AutoriaProjeto;
import com.sinergia.backend.dominio.repositorios.AutoriaProjetoRepositorio;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoriaServico {
    
    @Autowired
    private AutoriaProjetoRepositorio repositorio;

    @Transactional
    public AutoriaProjeto vincularDiscenteAoProjeto(AutoriaProjeto autoria) {

        if(autoria.getProjeto() == null || autoria.getDiscente() == null || autoria.getOrdemAutoria() == null) {
            throw new RegraNegocioExcecao("O vazio causaria crise existencial neste sistema; preencha os campos obrigatórios.");
        }

        boolean jaExiste = repositorio.findAll().stream().anyMatch(a ->
            a.getProjeto().getId().equals(autoria.getProjeto().getId()) &&
            a.getDiscente().getId().equals(autoria.getDiscente().getId()) &&
            a.getOrdemAutoria().getId().equals(autoria.getOrdemAutoria().getId())
        );

        if(jaExiste){
            throw new RegraNegocioExcecao("Este discente já possui este vínculo de autoria neste projeto.");
        }

        return repositorio.save(autoria);

    }

    public List<AutoriaProjeto> buscarAutoresPorProjeto(Integer projetoId){
        return repositorio.findAll().stream()
                .filter(a -> a.getProjeto().getId().equals(projetoId))
                .toList();
    }

}
