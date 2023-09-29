package com.example.cielo.models;

import jakarta.persistence.*;
import javax.validation.constraints.*;

@Entity
public class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 11)
    @Pattern(regexp = "^\\d{11}$")
    @NotNull
    private String cpf;

    @Column(nullable = false, length = 4)
    @Pattern(regexp = "^\\d{1,4}$")
    @NotNull
    private String mcc;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    @NotNull
    private String nome;

    @Column(nullable = false)
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    @NotNull
    private String email;

    // Constructors, getters, and setters

    public PessoaFisica() {
    }

    public String getCpf() {
        return cpf;
    }
    // Constructors, getters, and setters
}

