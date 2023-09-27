package com.example.cielochallenge.services;

import com.example.cielochallenge.models.PessoaFisica;
import com.example.cielochallenge.models.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@Service
public class PFService {

    @Autowired
    private Repository.CPFRepository repository;

    public Repository.CPFRepository savePFInfo(PessoaFisica pf) {
        if(repository.findByCPF(pf.getCpf())==null) {
            return (Repository.CPFRepository) repository.save(pf);
        } else {
            return null;
        }
    }
    public List<PessoaFisica> getAllPersonInfo() {
        return repository.findAll();
    }

    public Optional<PessoaFisica> getPersonInfoById(Long id) {
        return repository.findById(id);
    }

    public void deletePersonInfo(Long id) {
        repository.deleteById(id);
    }
}
