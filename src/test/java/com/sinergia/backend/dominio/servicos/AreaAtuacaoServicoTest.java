package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.modelos.AreaAtuacao;
import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class AreaAtuacaoServicoTest {

    @Autowired
    private AreaAtuacaoServico areaServico;

    @Test
    @DisplayName("Não deve permitir cadastrar a mesma área com letras maiúsculas ou minúsculas diferentes")
    void validarDuplicataCaseInsensitive() {
        AreaAtuacao area1 = new AreaAtuacao();
        area1.setDescricao("Desenvolvimento Web");
        areaServico.salvar(area1);

        AreaAtuacao area2 = new AreaAtuacao();
        area2.setDescricao("DESENVOLVIMENTO WEB");

        Assertions.assertThrows(RegraNegocioExcecao.class, () -> {
            areaServico.salvar(area2);
        });
    }
}