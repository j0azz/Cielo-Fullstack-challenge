package com.example.cielo.services;

import com.example.cielo.models.PessoaJuridica;
import com.example.cielo.models.PessoaFisica;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class QueueService {
    public LinkedList<String> Queue = new LinkedList<String>();
//    public LinkedList<String> pfQueue = new LinkedList<String>();

    public boolean empty(){
        return Queue.isEmpty();
    }

    public String findAndRequeueCustomer(String cpf_or_cnpj) {
        if (Queue.contains(cpf_or_cnpj)) {
            Queue.remove(cpf_or_cnpj);
            Queue.add(cpf_or_cnpj);
            return cpf_or_cnpj;
        }
        return null;
    }

    public String remove(String cpf_or_cnpj){
        if(Queue.contains(cpf_or_cnpj)){
            Queue.remove(cpf_or_cnpj);
            return cpf_or_cnpj;
        }
        return null;
    }
    public String getNext(){
        return Queue.poll();
    }

    public void addLast(String cpf_or_cnpj){
        Queue.addLast(cpf_or_cnpj);
    }

}
