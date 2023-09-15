package com.solucao.cadempresas.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.solucao.cadempresas.Model.Empresario;
import com.solucao.cadempresas.Repository.EmpresarioRepo;

@Component
public class EmpresarioService implements EmpresarioIM {
    @Autowired 
    private EmpresarioRepo empreRep;


    @Override
    public Empresario Autentica(String login, String senha) {
        // TODO Auto-generated method stub
        Empresario Aunt  = empreRep.findAll().stream()
        .filter(n -> n.getLogin().equals(login)&&n.getSenha().equals(senha))
        .findFirst().get();
        return Aunt;
    }// chama o método para depois cadastrar uma empresa

    @Override
    public ResponseEntity<Empresario> cadastrar(String login, String senha) {
       Empresario cnpj = new Empresario();
       cnpj.setLogin(login);
       cnpj.setSenha(senha); 
       empreRep.save(cnpj);
       return ResponseEntity.ok(cnpj);
    }
    
}
