package com.sinergia.backend.dominio.repositorios;

import com.sinergia.backend.dominio.modelos.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DiscenteRepositorio extends JpaRepository<Discente, Integer>{
    
    Optional<Discente> findByEmailInstitucional(String email);

    boolean existsByEmailInstitucional(String email);

    boolean existsByRa(String ra);

}
