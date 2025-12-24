package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "NIVEL_DISCENTE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COD_DISCENTE", "COD_HABILIDADE"})
})
@Data
public class NivelDiscente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_NIVEL_DISCENTE")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_DISCENTE", nullable = false)
    private Discente discente;

    @ManyToOne
    @JoinColumn(name = "COD_HABILIDADE", nullable = false)
    private Habilidade habilidade;

    @ManyToOne
    @JoinColumn(name = "COD_NIVEL_HABILIDADE", nullable = false)
    private NivelHabilidade nivel;

}
