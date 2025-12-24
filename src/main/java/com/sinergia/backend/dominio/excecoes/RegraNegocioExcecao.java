package com.sinergia.backend.dominio.excecoes;

public class RegraNegocioExcecao extends RuntimeException{
    
    public RegraNegocioExcecao(String mensagem) {
        super(mensagem);
    }

}
