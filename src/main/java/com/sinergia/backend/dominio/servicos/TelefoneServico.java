package com.sinergia.backend.dominio.servicos;

import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import com.sinergia.backend.dominio.modelos.Telefone;
import com.sinergia.backend.dominio.repositorios.TelefoneRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelefoneServico {

    @Autowired
    private TelefoneRepositorio repositorio;

    @Transactional
    public Telefone salvar(Telefone telefone) {
        String num = telefone.getNumero();

        if (!num.startsWith("+")) {
            throw new RegraNegocioExcecao("O telefone deve começar com '+' seguido do código do país.");
        }

        if (num.startsWith("+55")) {
            String apenasDigitos = num.substring(3); 
    
            if (apenasDigitos.length() != 11) {
                throw new RegraNegocioExcecao("Número inválido. Deve ter 11 dígitos após o +55 (DDD + número).");
            }
        } 
    
        else {
    
            if (num.length() < 8 || num.length() > 16) {
                throw new RegraNegocioExcecao("O número estrangeiro parece ter um tamanho inválido.");
            }
        }

        return repositorio.findByNumero(num)
                .orElseGet(() -> repositorio.save(telefone));
    }
}