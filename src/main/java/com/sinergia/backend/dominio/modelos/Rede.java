package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "REDE")
@Data
public class Rede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_REDE")
    private Integer id;

    @Column(name = "DESCRICAO_REDE", unique = true, nullable = false)
    private String descricao;
}