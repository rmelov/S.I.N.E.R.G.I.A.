package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import com.sinergia.backend.dominio.modelos.AutoriaProjeto;
import com.sinergia.backend.dominio.repositorios.AutoriaProjetoRepositorio;
import com.sinergia.backend.dominio.repositorios.DiscenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutoriaProjetoServico {

    @Autowired
    private DiscenteRepositorio discenteRepositorio;

    @Autowired
    private AutoriaProjetoRepositorio repositorio;

    @Transactional
    public AutoriaProjeto salvar(AutoriaProjeto autoria) {

        if(autoria.getDiscente() == null) {
            throw new RegraNegocioExcecao("Discente inválido.");
        }

        Integer discentId = autoria.getDiscente().getId();

        if(discentId == null){
            throw new RegraNegocioExcecao("Discente não informado.");
        }

        if(!discenteRepositorio.existsById(discentId)){
            throw new RegraNegocioExcecao("Discente inexistente na base de dados.");
        }

        String status = autoria.getProjeto().getStatus().getDescricao().toUpperCase();

        if (status.equals("FINALIZADO") || status.equals("SUSPENSO")) {
            throw new RegraNegocioExcecao("Não é permitido alterar a autoria de projetos com status: " + status + ".");
        }

        boolean jaPossuiEssePapel = repositorio.existsByProjetoAndDiscenteAndOrdemAutoria(
            autoria.getProjeto(), 
            autoria.getDiscente(), 
            autoria.getOrdemAutoria()
        );

        if (jaPossuiEssePapel) {
            throw new RegraNegocioExcecao("Por que (e como) a mesma pessoa assumiria mais de uma vez o mesmo papel simultaneamente?");
        }

        String papelAtual = autoria.getOrdemAutoria().getDescricao().toUpperCase();
    
        if (papelAtual.equals("AUTORIA PRINCIPAL") || papelAtual.equals("CO-AUTORIA")) {
            boolean jaEhAutorOuCoautor = repositorio.findByProjetoAndDiscente(autoria.getProjeto(), autoria.getDiscente())
                .stream()
                .anyMatch(a -> {
                    String desc = a.getOrdemAutoria().getDescricao().toUpperCase();
                    return desc.equals("AUTORIA PRINCIPAL") || desc.equals("CO-AUTORIA");
            });
        
            if (jaEhAutorOuCoautor) {
                throw new RegraNegocioExcecao("Assumir autoria principal e co-autoria no mesmo projeto?");
            }
        }

        return repositorio.save(autoria);
    }
}