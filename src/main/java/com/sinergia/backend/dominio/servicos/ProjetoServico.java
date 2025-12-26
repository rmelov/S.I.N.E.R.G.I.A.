package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import com.sinergia.backend.dominio.modelos.Projeto;
import com.sinergia.backend.dominio.repositorios.ProjetoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjetoServico {
    
    @Autowired
    private ProjetoRepositorio repositorio;

    @Transactional
    public Projeto salvar(Projeto projeto){

        if(projeto.getDescricao() == null || projeto.getDescricao().length() < 50) {
            throw new RegraNegocioExcecao("Descreva o pensamento inicial do projeto (mínimo de 50 caracteres).");
        }

        if(projeto.getPrazoConclusao() != null &&
            projeto.getPrazoConclusao().isBefore(projeto.getDataInicio())){
                throw new RegraNegocioExcecao("Faz sentido o prazo de conclusão ser anterior à data de início?");
        }
        
        return repositorio.save(projeto);

    }

}
