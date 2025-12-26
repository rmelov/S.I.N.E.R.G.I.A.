package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TELEFONE_DISCENTE")
@Data
public class TelefoneDiscente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_TELEFONE_DISCENTE")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_DISCENTE", nullable = false)
    private Discente discente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "COD_TELEFONE", nullable = false)
    private Telefone telefone;

}
