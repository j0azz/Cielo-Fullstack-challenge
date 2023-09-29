package com.example.cielo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class PessoaJuridica {
    @jakarta.persistence.Id
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 14)
    @NotNull
    @Pattern(regexp = "^\\d{14}$")
    private String cnpj;

    @Column(nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    private String razaoSocial;

    @Column(nullable = false, length = 4)
    @NotNull
    @Pattern(regexp = "^\\d{1,4}$")
    private String mcc;

    @Column(nullable = false, length = 11)
    @NotNull
    @Pattern(regexp = "^\\d{11}$")
    private String cpfContato;

    @Column(nullable = false, length = 50)
    @NotNull
    @Size(max = 50)
    private String nomeContato;

    @Column(nullable = false)
    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    private String emailContato;

    public PessoaJuridica() {
    }
    // Constructors, getters, and setters
    public String getCnpj(){
        return cnpj;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
