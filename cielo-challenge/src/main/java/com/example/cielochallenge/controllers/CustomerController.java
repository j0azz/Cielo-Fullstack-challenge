package com.example.cielochallenge.controllers;


        import com.example.cielochallenge.models.PessoaFisica;
        import com.example.cielochallenge.models.PessoaJuridica;
        import com.example.cielochallenge.services.PJService;
        import com.example.cielochallenge.services.PFService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Controller;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.*;

@SuppressWarnings("ALL")
@RestController
public class CustomerController {

    @Autowired
    private PJService pjService;

    @PostMapping("v1/pj/signup")
    public ResponseEntity savePJProspect(@RequestBody @Validated PessoaJuridica pj) {
        try {
            return ResponseEntity.ok(pjService.savePJInfo(pj));
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body("Error.");
        }
    }

    @Autowired
    private PFService pfService;

    @PostMapping("v1/pf/signup")
    public ResponseEntity savePFProspect(@RequestBody @Validated PessoaFisica pf) {
        try {
            return ResponseEntity.ok(pfService.savePFInfo(pf));
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body("Error.");
        }
    }
}