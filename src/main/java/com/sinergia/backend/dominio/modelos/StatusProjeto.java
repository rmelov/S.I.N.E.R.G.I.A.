package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "STATUS_PROJETO")
@Data

public class StatusProjeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_STATUS_PROJETO")
    private Integer id;

    @Column(name = "DESCRICAO_STATUS_PROJETO", unique = true, nullable = false)
    private String descricao;

}
