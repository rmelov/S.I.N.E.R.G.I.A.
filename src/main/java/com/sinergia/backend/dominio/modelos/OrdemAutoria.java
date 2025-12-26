package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ORDEM_AUTORIA")
@Data
public class OrdemAutoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ORDEM_AUTORIA")
    private Integer id;

    @Column(name = "DESCRICAO_ORDEM_AUTORIA", length = 100, unique = true, nullable = false)
    private String descricao;

}
