package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "NIVEL_HABILIDADE")
@Data
public class NivelHabilidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_NIVEL_HABILIDADE")
    private Integer id;

    @Column(name = "DESCRICAO_NIVEL", unique = true, nullable = false)
    private String descricao;

}
