package com.solucao.cadempresas.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apiguardian.api.API;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.solucao.cadempresas.Model.Empresa;
import com.solucao.cadempresas.Model.Empresario;
import com.solucao.cadempresas.Repository.EmpresarioRepo;
import com.solucao.cadempresas.Services.EmpresarioService;

public class MainTest {
    @InjectMocks
    private Main main;
    @Mock
    private Empresario empr;
    @Autowired
    
    private EmpresarioRepo empresarioRepo;

    @Mock
    private EmpresarioService empresarioService;

    @BeforeEach
    void Start(){
      MockitoAnnotations.openMocks(this);
    }    
    

    @Test
    void testCadastraEstabeleci() {

    }
    

    @Test
    void testAutentica() {
        Empresario empdr = new Empresario();
        StartEmpres();
        empdr.setId(7L);
        empdr.setLogin("Elton");
        empdr.setSenha("usuario#12");    
        Assertions.assertNotEquals(empdr, main.Autentica("Lucas@sum", "usuario#12"));
    }

    private void StartEmpres(){
        empr = new Empresario();
    }
}
