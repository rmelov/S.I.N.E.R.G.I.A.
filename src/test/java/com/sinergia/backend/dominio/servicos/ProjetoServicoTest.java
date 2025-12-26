package com.sinergia.backend.dominio.servicos;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import com.sinergia.backend.dominio.modelos.Projeto;
import com.sinergia.backend.dominio.modelos.StatusProjeto;
import com.sinergia.backend.dominio.repositorios.StatusProjetoRepositorio;

@SpringBootTest
public class ProjetoServicoTest {

    @Autowired
    private ProjetoServico projetoServico;

    @Autowired
    private StatusProjetoRepositorio statusRepo;

    @Test
    @DisplayName("Deve lançar exceção quando o prazo de conclusão for anterior ao início")
    void deveFalharComPrazoInvalido() {
        
        StatusProjeto status = statusRepo.findByDescricao("EM PLANEJAMENTO")
                                .orElseGet(() -> {
                                    StatusProjeto novo = new StatusProjeto();
                                    novo.setDescricao("EM PLANEJAMENTO");
                                    return statusRepo.save(novo);
                                });

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Paradoxo Temporal");
        projeto.setDescricao("Descrição obrigatória para o teste passar. Provável que tenha mais de 50 caracteres e seja suficiente para todas as pessoas envolvidas compreenderem o projeto, mesmo que minimamente.");
        projeto.setDataInicio(LocalDate.now());
        projeto.setPrazoConclusao(LocalDate.now().minusDays(1));
        projeto.setStatus(status);

        RegraNegocioExcecao excecao = assertThrows(RegraNegocioExcecao.class, () -> {
            projetoServico.salvar(projeto);
        });

        assertTrue(excecao.getMessage().contains("Faz sentido o prazo de conclusão ser anterior à data de início?"));
    }
}