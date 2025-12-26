package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.modelos.Discente;
import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional 
public class DiscenteServicoTest {

    @Autowired
    private DiscenteServico discenteServico;

    @Test
    @DisplayName("Deve lançar exceção ao cadastrar e-mail que não seja da Fatec")
    void validarEmailFatec() {
        Discente alunoInvalido = new Discente();
        alunoInvalido.setNome("Teste");
        alunoInvalido.setRa("1234567890123");
        alunoInvalido.setEmailInstitucional("teste@gmail.com");

        Assertions.assertThrows(RegraNegocioExcecao.class, () -> {
            discenteServico.salvar(alunoInvalido);
        });
    }

    @Test
    @DisplayName("Deve impedir o cadastro de dois alunos com o mesmo RA")
    void validarRaDuplicado() {
        Discente aluno1 = new Discente();
        aluno1.setNome("Aluno Um");
        aluno1.setRa("1112223334445");
        aluno1.setEmailInstitucional("aluno1@fatec.sp.gov.br");
        discenteServico.salvar(aluno1);

        Discente aluno2 = new Discente();
        aluno2.setNome("Aluno Dois");
        aluno2.setRa("1112223334445"); 
        aluno2.setEmailInstitucional("aluno2@fatec.sp.gov.br");

        Assertions.assertThrows(RegraNegocioExcecao.class, () -> {
            discenteServico.salvar(aluno2);
        });
    }
}