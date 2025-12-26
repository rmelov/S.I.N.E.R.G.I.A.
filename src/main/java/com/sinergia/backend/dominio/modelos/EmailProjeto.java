package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "EMAIL_PROJETO", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COD_PROJETO", "COD_EMAIL"})
})
@Data
public class EmailProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_EMAIL_PROJETO")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_PROJETO", nullable = false)
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "COD_EMAIL", nullable = false)
    private Email email;
}