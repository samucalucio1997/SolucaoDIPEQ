package com.solucao.cadempresas.Services;

import org.springframework.http.ResponseEntity;

import com.solucao.cadempresas.Model.Empresario;

public interface EmpresarioIM {
    public Empresario Autentica(String login, String senha);
    public ResponseEntity<Empresario> cadastrar(String login,String senha);
}
