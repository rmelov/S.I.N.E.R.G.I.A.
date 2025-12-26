package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "REDE_DISCENTE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COD_DISCENTE", "URL_REDE"})
})
@Data
public class RedeDiscente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_REDE_DISCENTE")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_DISCENTE", nullable = false)
    private Discente discente;

    @ManyToOne
    @JoinColumn(name = "COD_REDE", nullable = false)
    private Rede rede;

    @org.hibernate.validator.constraints.URL(message = "URL inválida. O que você está fazendo?")
    @Column(name = "URL_REDE", unique = true, nullable = false)
    private String url;
}