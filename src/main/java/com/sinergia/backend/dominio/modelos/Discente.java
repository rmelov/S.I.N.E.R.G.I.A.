package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "DISCENTE")
@Data
public class Discente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_DISCENTE")
    private Integer id;

    @Column(name = "RA_DISCENTE", unique = true, nullable = false, length = 15)
    private String ra;

    @Column(name = "NOME_DISCENTE", nullable = false, length = 255)
    private String nome;

    @Column(name = "EMAIL_INSTITUCIONAL_DISCENTE", unique = true, nullable = false)
    private String emailInstitucional;
    
    @ManyToOne
    @JoinColumn(name = "COD_STATUS_DISCENTE")
    private StatusDiscente status;

    @ManyToMany
    @JoinTable(
        name = "DISCENTE_CURSO",
        joinColumns = @JoinColumn(name = "COD_DISCENTE"),
        inverseJoinColumns = @JoinColumn(name = "COD_CURSO")
    )
    private List<Curso> cursos;

}
