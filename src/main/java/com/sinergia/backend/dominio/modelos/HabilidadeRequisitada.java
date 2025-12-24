package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "HABILIDADE_REQUISITADA")
@Data
public class HabilidadeRequisitada {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_HABILIDADE_REQUISITADA")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_PROJETO", nullable = false)
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "COD_HABILIDADE", nullable = false)
    private Habilidade habilidade;

    @ManyToOne
    @JoinColumn(name = "COD_NIVEL_HABILIDADE", nullable = false)
    private NivelHabilidade nivelMinimo;

}
