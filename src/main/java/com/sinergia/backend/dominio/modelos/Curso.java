package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CURSO")
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CURSO")
    private Integer codCurso;

    @Column(name = "NOME_CURSO", length = 255, unique = true, nullable = false)
    private String nomeCurso;

}