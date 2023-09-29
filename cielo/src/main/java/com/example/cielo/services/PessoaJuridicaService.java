package com.example.cielo.services;

import com.example.cielo.models.PessoaJuridica;
import com.example.cielo.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan
@Service
public class PessoaJuridicaService {
    private final PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    public PessoaJuridicaService(PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    public boolean delete(String cnpj){
        PessoaJuridica pj = pessoaJuridicaRepository.findByCnpj(cnpj);
        if(pj==null){
            return false;
        }
        else {
            pessoaJuridicaRepository.delete(pessoaJuridicaRepository.findByCnpj(cnpj));
            return true;
        }
    }

    public boolean verify(String cnpj){
        PessoaJuridica pj = pessoaJuridicaRepository.findByCnpj(cnpj);
        if(pj==null){
            return false;
        }
        else return true;
    }
    public PessoaJuridica create(PessoaJuridica pessoaJuridica){
        PessoaJuridica pj = pessoaJuridicaRepository.findByCnpj(pessoaJuridica.getCnpj());
        if(pj==null){
            PessoaJuridica response = pessoaJuridicaRepository.save(pessoaJuridica);
            return response;
        }
        return null;

    }

    public PessoaJuridica update(PessoaJuridica pessoaJuridica){
        PessoaJuridica pj = pessoaJuridicaRepository.findByCnpj(pessoaJuridica.getCnpj());
        if(pj==null){
            return null;
        }
        pessoaJuridicaRepository.delete(pj);
        PessoaJuridica response = pessoaJuridicaRepository.save(pessoaJuridica);
        return response;
    }
}
