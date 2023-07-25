package com.acerta.rest.dto;


import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class UserDTO {
    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, message = "Senha deve ser maior que 8 caracteres")
    private String password;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO(String cpf, String password) {
        this.cpf = cpf;
        this.password = password;
    }

    public UserDTO() {
    }

}
