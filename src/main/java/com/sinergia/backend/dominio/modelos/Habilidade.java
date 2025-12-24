package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "HABILIDADE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COD_HABILIDADE", "COD_CURSO"})
})
@Data

public class Habilidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_HABILIDADE")
    private Integer id;

    @Column(name = "DESCRICAO_HABILIDADE", unique = true)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "COD_CURSO", nullable = false)
    private Curso curso;

}
