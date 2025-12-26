package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "AREA_ATUACAO_PROJETO", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COD_PROJETO", "COD_AREA_ATUACAO"})
})
@Data
public class AreaAtuacaoProjeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_AREA_ATUACAO_PROJETO")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_PROJETO", nullable = false)
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "COD_AREA_ATUACAO", nullable = false)
    private AreaAtuacao areaAtuacao;

}
