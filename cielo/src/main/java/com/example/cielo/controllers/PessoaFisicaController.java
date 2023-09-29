package com.example.cielo.controllers;

import com.example.cielo.models.PessoaFisica;
import com.example.cielo.models.PessoaJuridica;
import com.example.cielo.services.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ComponentScan
@RestController
@RequestMapping("/clients")
public class PessoaFisicaController {

    private final PessoaFisicaService pfService;

    @Autowired
     public PessoaFisicaController(PessoaFisicaService pfService) {
        this.pfService = pfService;
    }

    @GetMapping("/pf/consult/{cnpj}")
    public ResponseEntity<?> verifyClient(@RequestParam String cnpj) {
        if (pfService.verify(cnpj)) {//if it is null it already exists
            return ResponseEntity.status(HttpStatus.FOUND).body("Client found.");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        }
    }

    @PostMapping("/pf/create")
    public ResponseEntity<?> createClient(@RequestBody PessoaFisica client) {
        if (!isValidClientData(client)) {
            return ResponseEntity.badRequest().body("Invalid client data. Please check the provided information.");
        }
        else {
            PessoaFisica createdPFProspect = pfService.create(client);
            if (createdPFProspect==null) {//if it is null it already exists
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Client already exists.");
            }
            else {
                return ResponseEntity.status(HttpStatus.CREATED).body("Client" +createdPFProspect.getCpf()+" created successfully!");
            }
        }
    }

    @PostMapping("/pf/update")
    public ResponseEntity<?> updateClient(@RequestBody PessoaFisica client) {
        if (!isValidClientData(client)) {
            return ResponseEntity.badRequest().body("Invalid client data. Please check the provided information.");
        }
        else {
            PessoaFisica createdPFProspect = pfService.update(client);
            if (createdPFProspect==null) {//if it is null it does not exist
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client does not exist.");
            }
            else {
                return ResponseEntity.status(HttpStatus.OK).body("Client" +createdPFProspect.getCpf()+" updated successfully!");
            }
        }
    }

    @GetMapping("/pf/delete/{cpf}")
    public ResponseEntity<?> deleteClient(@RequestParam String cpf) {
        if (pfService.verify(cpf)) {//if it is null it already exists
            pfService.delete(cpf);
            return ResponseEntity.status(HttpStatus.OK).body("Client deleted.");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found, nor deleted.");
        }
    }
    // Helper method to validate client data
    private boolean isValidClientData(PessoaFisica client) {
        // Implement your validation logic here based on the rules
        // For example, check if fields meet the required criteria
        // You can also use other validation libraries or methods
        // Return true if data is valid, false otherwise
        return true;
    }
}
