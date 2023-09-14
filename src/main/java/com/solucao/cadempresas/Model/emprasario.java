package com.solucao.cadempresas.Model;

import jakarta.persistence.Entity;

@Entity
public class emprasario {
    private String login;
    private String senha;


    private Empresa empresa;

    


    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    

}
