package com.example.cielochallenge.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public class Repository {

    public interface CNPJRepository extends JpaRepository<PessoaJuridica, Long> {
        // Define custom query methods if needed
        @Query(value = "SELECT * FROM PessoaJuridica WHERE cnpj=?",nativeQuery = true)
        public PessoaJuridica findByCNPJ(String cnpj);
    }

    public interface CPFRepository extends JpaRepository<PessoaFisica, Long> {
        // Define custom query methods if needed
        @Query(value = "SELECT * FROM PessoaFisica WHERE cpf=?",nativeQuery = true)
        public PessoaFisica findByCPF(String cpf);
    }
}
