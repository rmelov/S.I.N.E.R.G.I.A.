package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "TELEFONE")
@Data
public class Telefone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_TELEFONE")
    private Integer id;

    @NotBlank
    @Size(min = 8, max = 20)
    @Column(name = "NUMERO_TELEFONE", unique = true, nullable = false, length = 20)
    private String numero;

    public void setNumero(String numero){

        if(numero != null){
            this.numero = numero.replaceAll("[^0-9+]", "");
        }
    }

}
