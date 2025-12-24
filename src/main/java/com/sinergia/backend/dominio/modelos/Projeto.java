package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "PROJETO")
@Data
public class Projeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PROJETO")
    private Integer id;

    @Column(name = "NOME_PROJETO", nullable = false)
    private String nome;

    @Column(name = "DESCRICAO_PROJETO", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "PRAZO_CONCLUSAO")
    private LocalDate prazoConclusao;

    @ManyToOne
    @JoinColumn(name = "COD_STATUS_PROJETO", nullable = false)
    private StatusProjeto staus;

}
