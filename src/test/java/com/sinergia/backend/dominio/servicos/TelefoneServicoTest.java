package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import com.sinergia.backend.dominio.modelos.Telefone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TelefoneServicoTest {

    @Autowired
    private TelefoneServico telefoneServico;

    @Test
    @DisplayName("Deve aceitar número estrangeiro válido")
    void deveAceitarEstrangeiro() {
        Telefone tel = new Telefone();
        tel.setNumero("+12025550101");
        
        Assertions.assertDoesNotThrow(() -> telefoneServico.salvar(tel));
    }

    @Test
    @DisplayName("Deve rejeitar número brasileiro inválido")
    void deveRejeitarBrasileiroInvalido() {
        Telefone tel = new Telefone();
        tel.setNumero("+552198181");

        Assertions.assertThrows(RegraNegocioExcecao.class, () -> {
            telefoneServico.salvar(tel);
        });
    }
}