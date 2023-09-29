package com.example.cielo.repositories;

import com.example.cielo.models.PessoaJuridica;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@ComponentScan
@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
    boolean existsByCnpj(String cnpj);
    PessoaJuridica findByCnpj(String cnpj);
}
