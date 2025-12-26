package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.modelos.Telefone;
import com.sinergia.backend.dominio.modelos.TelefoneProjeto;
import com.sinergia.backend.dominio.repositorios.TelefoneProjetoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelefoneProjetoServico {

    @Autowired
    private TelefoneProjetoRepositorio vinculoRepositorio;

    @Autowired
    private TelefoneServico telefoneServico;

    @Transactional
    public TelefoneProjeto vincular(TelefoneProjeto vinculo) {
        
        Telefone telefoneValidado = telefoneServico.salvar(vinculo.getTelefone());
        
        vinculo.setTelefone(telefoneValidado);

        return vinculoRepositorio.save(vinculo);
    }
}