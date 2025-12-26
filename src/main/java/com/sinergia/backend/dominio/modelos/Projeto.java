package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @Size(min = 50, message = "Descreva o pensamento inicial do projeto (mínimo de 50 caracteres).")
    private String descricao;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "PRAZO_CONCLUSAO")
    private LocalDate prazoConclusao;

    @ManyToOne
    @JoinColumn(name = "COD_STATUS_PROJETO", nullable = false)
    private StatusProjeto status;

    @PrePersist
    protected void aoCriar() {
        if (this.dataInicio == null) {
            this.dataInicio = LocalDate.now();
        }
    }

}
