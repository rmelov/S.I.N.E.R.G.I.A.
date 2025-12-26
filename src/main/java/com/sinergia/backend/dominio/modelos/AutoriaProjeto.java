package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "AUTORIA_PROJETO", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COD_PROJETO", "COD_DISCENTE", "COD_ORDEM_AUTORIA"})
})
@Data
public class AutoriaProjeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_AUTORIA_PROJETO")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_PROJETO", nullable = false)
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "COD_DISCENTE", nullable = false)
    private Discente discente;

    @ManyToOne
    @JoinColumn(name = "COD_ORDEM_AUTORIA", nullable = false)
    private OrdemAutoria ordemAutoria;

}
