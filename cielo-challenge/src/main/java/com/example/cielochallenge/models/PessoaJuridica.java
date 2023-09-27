package com.example.cielochallenge.models;

import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
public class PessoaJuridica {
    @Size(min = 14, max = 14, message = "CNPJ must have exactly 14 digits")
    @Pattern(regexp = "^[0-9]{14}$", message = "CNPJ must consist of 14 digits")
    private String cnpj;

    @Size(max = 50, message = "Razão Social cannot exceed 50 characters")
    private String razaoSocial;

    @Size(max = 4, message = "MCC must have at most 4 characters")
    private String mcc;

    @Size(min = 11, max = 11, message = "CPF must have exactly 11 digits")
    @Pattern(regexp = "^[0-9]{11}$", message = "CPF must consist of 11 digits")
    private String cpfContato;

    @Size(max = 50, message = "Nome do contato cannot exceed 50 characters")
    private String nomeContato;

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Invalid email format")
    private String emailContato;

    // Getters and setters

    public String getCNPJ(){
        return this.cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public void setCpfContato(String cpfContato) {
        this.cpfContato = cpfContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }
}
