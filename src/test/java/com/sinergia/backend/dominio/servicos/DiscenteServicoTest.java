package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.modelos.Discente;
import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiscenteServicoTest {

    @Autowired
    private DiscenteServico discenteServico;

    @Test
    @DisplayName("Deve lançar exceção ao cadastrar e-mail que não seja da Fatec")
    void validarEmailFatec() {
        Discente alunoInvalido = new Discente();
        alunoInvalido.setNome("Teste");
        alunoInvalido.setRa("123456789");
        alunoInvalido.setEmailInstitucional("teste@gmail.com");

        Assertions.assertThrows(RegraNegocioExcecao.class, () -> {
            discenteServico.salvar(alunoInvalido);
        });
    }
}