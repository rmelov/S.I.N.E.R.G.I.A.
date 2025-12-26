package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "AREA_ATUACAO")
@Data
public class AreaAtuacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_AREA_ATUACAO")
    private Integer id;

    @Column(name = "DESCRICAO_AREA_ATUACAO", unique = true, nullable = false)
    private String descricao;

}
