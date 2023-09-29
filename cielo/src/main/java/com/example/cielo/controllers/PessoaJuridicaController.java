package com.example.cielo.controllers;

import com.example.cielo.models.PessoaJuridica;
import com.example.cielo.services.PessoaJuridicaService;
import com.example.cielo.services.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ComponentScan
@RestController
@RequestMapping("/clients")
public class PessoaJuridicaController {

    private final PessoaJuridicaService pjService;
    private final QueueService queueService;

    @Autowired
    public PessoaJuridicaController(PessoaJuridicaService pjService) {
        queueService= new QueueService();
        this.pjService = pjService;
    }

    @GetMapping("/pj/consult/{cnpj}")
    public ResponseEntity<?> verifyClient(@RequestParam String cnpj) {
        if (pjService.verify(cnpj)) {//if it is null it already exists
            return ResponseEntity.status(HttpStatus.FOUND).body("Client found.");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        }
    }

    @PostMapping("/pj/create")
    public ResponseEntity<?> createClient(@RequestBody PessoaJuridica client) {
        if (!isValidClientData(client)) {
            return ResponseEntity.badRequest().body("Invalid client data. Please check the provided information.");
        }
        else {
            PessoaJuridica createdPJProspect = pjService.create(client);
            if (createdPJProspect==null) {//if it is null it already exists
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Client already exists.");
            }
            else {
                queueService.addLast(client.getCnpj());
                return ResponseEntity.status(HttpStatus.CREATED).body("Client" +createdPJProspect.getCnpj()+" created successfully!");
            }
        }
    }

    @PostMapping("/pj/update")
    public ResponseEntity<?> updateClient(@RequestBody PessoaJuridica client) {
        if (!isValidClientData(client)) {
            return ResponseEntity.badRequest().body("Invalid client data. Please check the provided information.");
        }
        else {
            PessoaJuridica createdPJProspect = pjService.update(client);
            if (createdPJProspect==null) {//if it is null it does not exist
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client does not exist.");
            }
            else {
                queueService.findAndRequeueCustomer(client.getCnpj());
                return ResponseEntity.status(HttpStatus.OK).body("Client" +createdPJProspect.getCnpj()+" updated successfully!");
            }
        }
    }

    @GetMapping("/pj/delete/{cnpj}")
    public ResponseEntity<?> deleteClient(@RequestParam String cnpj) {
        if (pjService.verify(cnpj)) {//if it is null it already exists
            pjService.delete(cnpj);
            queueService.remove(cnpj);
            return ResponseEntity.status(HttpStatus.OK).body("Client deleted.");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found, nor deleted.");
        }
    }
    // Helper method to validate client data
    private boolean isValidClientData(PessoaJuridica client) {
        // Implement your validation logic here based on the rules
        // For example, check if fields meet the required criteria
        // You can also use other validation libraries or methods
        // Return true if data is valid, false otherwise
        return true;
    }
}
