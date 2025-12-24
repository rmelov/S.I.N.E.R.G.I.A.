package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "STATUS_DISCENTE")
@Data

public class StatusDiscente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_STATUS_DISCENTE")
    private Integer id;

    @Column(name = "DESCRICAO_STATUS_DISCENTE", unique = true, nullable = false, length = 255)
    private String descricao;

}
