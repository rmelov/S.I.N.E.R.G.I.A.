package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "EMAIL")
@Data
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_EMAIL")
    private Integer id;

    @Column(name = "ENDERECO_EMAIL", unique = true, nullable = false)
    @jakarta.validation.constraints.Email(message = "Insira um e-mail válido.")
    @NotBlank(message = "O e-mail não pode estar vazio.")
    private String endereco;

}