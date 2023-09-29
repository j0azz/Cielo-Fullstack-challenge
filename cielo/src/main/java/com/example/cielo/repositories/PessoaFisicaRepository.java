package com.example.cielo.repositories;

import com.example.cielo.models.PessoaFisica;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@ComponentScan
@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    boolean existsByCpf(String cpf);
    PessoaFisica findByCpf(String cpf);
}
