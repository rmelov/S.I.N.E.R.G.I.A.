package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TELEFONE_PROJETO")
@Data
public class TelefoneProjeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_TELEFONE_PROJETO")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_PROJETO", nullable = false)
    private Projeto projeto;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "COD_TELEFONE", nullable = false)
    private Telefone telefone;

}