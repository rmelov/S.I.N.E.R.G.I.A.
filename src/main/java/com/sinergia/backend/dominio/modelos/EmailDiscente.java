package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "EMAIL_DISCENTE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COD_DISCENTE", "COD_EMAIL"})
})
@Data
public class EmailDiscente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_EMAIL_DISCENTE")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_DISCENTE", nullable = false)
    private Discente discente;

    @ManyToOne
    @JoinColumn(name = "COD_EMAIL", nullable = false)
    private Email email;
}