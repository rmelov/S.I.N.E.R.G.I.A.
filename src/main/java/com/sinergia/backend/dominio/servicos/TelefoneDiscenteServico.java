package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.modelos.Telefone;
import com.sinergia.backend.dominio.modelos.TelefoneDiscente;
import com.sinergia.backend.dominio.repositorios.TelefoneDiscenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelefoneDiscenteServico {

    @Autowired
    private TelefoneDiscenteRepositorio vinculoRepositorio;

    @Autowired
    private TelefoneServico telefoneServico;

    @Transactional
    public TelefoneDiscente vincular(TelefoneDiscente vinculo) {
        
        Telefone telefoneValidado = telefoneServico.salvar(vinculo.getTelefone());
        
        vinculo.setTelefone(telefoneValidado);

        return vinculoRepositorio.save(vinculo);
    }
}