package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TelefoneRepositorio extends JpaRepository<Telefone, Integer> {
    
    Optional<Telefone> findByNumero(String numero);

}