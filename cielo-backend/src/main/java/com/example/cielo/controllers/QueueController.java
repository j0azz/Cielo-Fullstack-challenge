package com.example.cielo.controllers;

import com.example.cielo.models.PessoaFisica;
import com.example.cielo.models.PessoaJuridica;
import com.example.cielo.services.PessoaFisicaService;
import com.example.cielo.services.PessoaJuridicaService;
import com.example.cielo.services.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ComponentScan
@RestController
@RequestMapping("/queue")
public class QueueController {
    private final QueueService queueService;
    private PessoaJuridicaService pessoaJuridicaService;
    private  PessoaFisicaService pessoaFisicaService;

    @Autowired
    public QueueController(QueueService queueService) {
        this.queueService = queueService;
        this.pessoaJuridicaService = pessoaJuridicaService;
        this.pessoaFisicaService = pessoaFisicaService;
    }

    @GetMapping("/next")
    public ResponseEntity<?> next(){
        if(queueService.empty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("The queue is empty, no prospects to see.");
        }
        else {
            String next_credential = queueService.getNext();
            if(next_credential.length()==11){
                PessoaFisica pf = pessoaFisicaService.getData(next_credential);
                queueService.remove(next_credential);
                return ResponseEntity.status(HttpStatus.FOUND).body(pf);
            }
            if(next_credential.length()==14){
                PessoaJuridica pj = pessoaJuridicaService.getData(next_credential);
                queueService.remove(next_credential);
                return ResponseEntity.status(HttpStatus.FOUND).body(pj);
            }
            else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error retrieving data, maybe because you provided invalid credentials; no prospects to see.");
            }

        }
    }
}
