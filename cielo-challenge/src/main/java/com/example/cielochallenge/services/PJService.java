package com.example.cielochallenge.services;

import com.example.cielochallenge.models.PessoaJuridica;
import com.example.cielochallenge.models.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PJService {

    @Autowired
    private Repository.CNPJRepository repository;

    public Repository.CNPJRepository savePJInfo(PessoaJuridica pj) {
        if(repository.findByCNPJ(pj.getCNPJ())==null) {
            return (Repository.CNPJRepository) repository.save(pj);
        } else {
            return null;
        }
    }

    public List<PessoaJuridica> getAllEstablishmentInfo() {

        return repository.findAll();
    }

    public Optional<PessoaJuridica> getEstablishmentInfoById(Long id) {
        return repository.findById(id);
    }



    public void deleteEstablishmentInfo(Long id) {
        repository.deleteById(id);
    }
}