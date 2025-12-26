package com.sinergia.backend.api.excecoes;

import com.sinergia.backend.dominio.excecoes.RegraNegocioExcecao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegraNegocioExcecao.class)
    public ResponseEntity<?> tratarRegraNegocio(RegraNegocioExcecao ex){
        return ResponseEntity.badRequest().body(Map.of(
            "status", 400,
            "erro", "Violação de Regra de Negócio",
            "mensagem", ex.getMessage()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> tratarErroInesperado(Exception ex){
        return ResponseEntity.internalServerError().body(Map.of(
            "status", 500,
            "erro", "Erro interno do servidor",
            "mensagem", "Erro inesperado. Contate o(a) adminstrador(a)."
        ));
    }

}
