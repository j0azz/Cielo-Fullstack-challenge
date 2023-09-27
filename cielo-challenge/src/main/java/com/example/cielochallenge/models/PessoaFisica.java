package com.example.cielochallenge.models;

import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class PessoaFisica {

    @Size(min = 11, max = 11, message = "CPF must have exactly 11 digits")
    @Pattern(regexp = "^[0-9]{11}$", message = "CPF must consist of 11 digits")
    private String cpf;

    @Size(max = 4, message = "MCC must have at most 4 characters")
    private String mcc;

    @Size(max = 50, message = "Nome da pessoa cannot exceed 50 characters")
    private String nome;

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$",
            message = "Invalid email format")
    private String email;

    // Getters and setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
