package com.example.cielo.services;

import com.example.cielo.models.PessoaFisica;
import com.example.cielo.models.PessoaJuridica;
import com.example.cielo.repositories.PessoaFisicaRepository;
import com.example.cielo.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan
@Service
public class PessoaFisicaService {
    private final PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
    }

    public boolean delete(String cpf){
        PessoaFisica pf = pessoaFisicaRepository.findByCpf(cpf);
        if(pf==null){
            return false;
        }
        else {
            pessoaFisicaRepository.delete(pessoaFisicaRepository.findByCpf(cpf));
            return true;
        }
    }

    public boolean verify(String cpf){
        PessoaFisica pf = pessoaFisicaRepository.findByCpf(cpf);
        if(pf==null){
            return false;
        }
        else return true;
    }
    public PessoaFisica create(PessoaFisica pessoaFisica){
        PessoaFisica pf = pessoaFisicaRepository.findByCpf(pessoaFisica.getCpf());
        if(pf==null){
            PessoaFisica response = pessoaFisicaRepository.save(pessoaFisica);
            return response;
        }
        return null;

    }

    public PessoaFisica update(PessoaFisica pessoaFisica){
        PessoaFisica pf = pessoaFisicaRepository.findByCpf(pessoaFisica.getCpf());
        if(pf==null){
            return null;
        }
        pessoaFisicaRepository.delete(pf);
        PessoaFisica response = pessoaFisicaRepository.save(pessoaFisica);
        return response;
    }
}
