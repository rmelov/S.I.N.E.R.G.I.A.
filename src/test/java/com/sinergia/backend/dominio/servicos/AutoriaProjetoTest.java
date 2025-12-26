package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import com.sinergia.backend.dominio.modelos.*;
import com.sinergia.backend.dominio.repositorios.*; // Importe os repositórios
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@Transactional 
public class AutoriaProjetoTest {

    @Autowired
    private AutoriaProjetoServico autoriaServico;

    @Autowired
    private ProjetoServico projetoServico;

    @Autowired
    private StatusProjetoRepositorio statusProjetoRepositorio;

    @Autowired
    private ProjetoRepositorio projetoRepositorio;

    @Autowired
    private DiscenteRepositorio discenteRepositorio;

    @Autowired
    private OrdemAutoriaRepositorio ordemAutoriaRepositorio;

    @Test
    @DisplayName("Regra: Deve impedir autoria em projeto FINALIZADO")
    void deveBloquearProjetoFinalizado() {
        StatusProjeto statusFinalizado = new StatusProjeto();
        statusFinalizado.setDescricao("FINALIZADO");

        Projeto proj = new Projeto();
        proj.setStatus(statusFinalizado);
        proj.setNome("Projeto Concluído");
        proj.setDataInicio(LocalDate.now().minusDays(10));

        AutoriaProjeto autoria = new AutoriaProjeto();
        autoria.setProjeto(proj);
        autoria.setDiscente(new Discente());

        OrdemAutoria papel = new OrdemAutoria();
        papel.setDescricao("APOIO TÉCNICO");
        autoria.setOrdemAutoria(papel);

        Assertions.assertThrows(RegraNegocioExcecao.class, () -> {
            autoriaServico.salvar(autoria);
        });
    }

    String descricaoProjetoTeste = "Descrição obrigatória para o teste passar. Provável que tenha mais de 50 caracteres e seja suficiente para todas as pessoas envolvidas compreenderem o projeto, mesmo que minimamente.";

    @Test
    @DisplayName("Regra: Deve impedir que Autor Principal assuma Co-autoria")
    void deveImpedirConcorrenciaDeAutoria() {

        StatusProjeto statusAtivo = new StatusProjeto();
        statusAtivo.setDescricao("EM DESENVOLVIMENTO");
        statusAtivo = statusProjetoRepositorio.save(statusAtivo);

        Projeto projetoAtivo = new Projeto();
        projetoAtivo.setStatus(statusAtivo);
        projetoAtivo.setNome("Projeto Alpha");
        projetoAtivo.setDescricao(descricaoProjetoTeste);
        projetoAtivo.setDataInicio(LocalDate.now());
        projetoAtivo = projetoRepositorio.save(projetoAtivo);

        Discente discente = new Discente();
        discente.setNome("Vixnu");
        discente.setRa("123456789");
        discente.setEmailInstitucional("vixnu@fatec.sp.gov.br");
        discente = discenteRepositorio.save(discente);

        OrdemAutoria papelPrincipal = new OrdemAutoria();
        papelPrincipal.setDescricao("AUTORIA PRINCIPAL");
        papelPrincipal = ordemAutoriaRepositorio.save(papelPrincipal);

        OrdemAutoria papelCoAutoria = new OrdemAutoria();
        papelCoAutoria.setDescricao("CO-AUTORIA");
        papelCoAutoria = ordemAutoriaRepositorio.save(papelCoAutoria);

        AutoriaProjeto primeira = new AutoriaProjeto();
        primeira.setProjeto(projetoAtivo);
        primeira.setDiscente(discente);
        primeira.setOrdemAutoria(papelPrincipal);
        autoriaServico.salvar(primeira);

        AutoriaProjeto segundaAutoria = new AutoriaProjeto();
        segundaAutoria.setProjeto(projetoAtivo);
        segundaAutoria.setDiscente(discente);
        segundaAutoria.setOrdemAutoria(papelCoAutoria);

        Assertions.assertThrows(RegraNegocioExcecao.class, () -> {
            autoriaServico.salvar(segundaAutoria);
        });
    }

    @Test
    @DisplayName("Quebra A: Deve impedir autoria de Discente Fantasma")
    void deveImpedirDiscenteInexistente() {
        
        StatusProjeto status = statusProjetoRepositorio.findByDescricao("EM PLANEJAMENTO")
            .orElseGet(() -> {
                StatusProjeto novo = new StatusProjeto();
                novo.setDescricao("EM PLANEJAMENTO");
                return statusProjetoRepositorio.save(novo);
        });

        Projeto proj = new Projeto();
        proj.setNome("Projeto Teste Fantasma");
        proj.setDescricao(descricaoProjetoTeste);
        proj.setDataInicio(LocalDate.now());
        proj.setStatus(status);
        proj = projetoRepositorio.save(proj);

        OrdemAutoria papel = new OrdemAutoria();
        papel.setDescricao("MEMBRO");
        papel = ordemAutoriaRepositorio.save(papel);

        Discente fantasma = new Discente();
        fantasma.setId(9999);

        AutoriaProjeto autoria = new AutoriaProjeto();
        autoria.setProjeto(proj);
        autoria.setDiscente(fantasma);
        autoria.setOrdemAutoria(papel);

        Assertions.assertThrows(RegraNegocioExcecao.class, () -> {
            autoriaServico.salvar(autoria);
        });
    }

    @Test
    @DisplayName("Regra: Deve impedir prazo de conclusão antes do prazo de início")
    void deveImpedirPrazoRetroativo() {
        
        StatusProjeto status = new StatusProjeto();
        status.setDescricao("RASCUNHO");
        status = statusProjetoRepositorio.save(status);

        Projeto projetoBugado = new Projeto();
        projetoBugado.setNome("Projeto Viagem no Tempo");
        projetoBugado.setDescricao(descricaoProjetoTeste);
        projetoBugado.setDataInicio(LocalDate.now());
        projetoBugado.setPrazoConclusao(LocalDate.now().minusDays(1));
        projetoBugado.setStatus(status);

        Assertions.assertThrows(RegraNegocioExcecao.class, () -> {
            projetoServico.salvar(projetoBugado);
        });
    }
}