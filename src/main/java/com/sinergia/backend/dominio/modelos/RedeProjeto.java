package com.sinergia.backend.dominio.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "REDE_PROJETO", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COD_PROJETO", "URL_REDE"})
})
@Data
public class RedeProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_REDE_PROJETO")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COD_PROJETO", nullable = false)
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "COD_REDE", nullable = false)
    private Rede rede;

    @Column(name = "URL_REDE", unique = true, nullable = false)
    private String url;
}