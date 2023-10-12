package com.solucao.cadempresas.Controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solucao.cadempresas.Model.Empresa;
import com.solucao.cadempresas.Model.Empresario;
import com.solucao.cadempresas.Model.FaturamentoMensal;
import com.solucao.cadempresas.Repository.EmpresaRepo;
import com.solucao.cadempresas.Repository.EmpresarioRepo;
import com.solucao.cadempresas.Services.EmpresaService;
import com.solucao.cadempresas.Services.EmpresarioService;
import com.solucao.cadempresas.Services.FatuMensalService;

@RestController
@RequestMapping("/root")
public class Main {
    @Autowired
    private EmpresarioService SeviceEmpres;

    @Autowired
    private EmpresaRepo emprepo;

    @Autowired
    private EmpresarioRepo empresarios;


    @Autowired
    private EmpresaService empresaService;
     
    @Autowired
    private FatuMensalService faturaMens;

    
    private Empresario empdor;

    private Empresa empre;

    @PostMapping(value = "/cadastroPJ", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresario> CadastraCNPJ(@RequestBody Empresario empresario){
        ResponseEntity<Empresario> empresar = 
         SeviceEmpres.cadastrar(empresario.getLogin(), empresario.getSenha()); 
         empdor =empresario;
         return empresar;
    }
    @GetMapping("/empresaCons")
    public Empresa Teste(){
        // empresaService.Consulta(empdor);
      return empre; 
    }

    @GetMapping("/Auth")
    public ResponseEntity<Boolean> Autentica(@RequestHeader String login,
    @RequestHeader String senha){
        empdor =SeviceEmpres.Autentica(login, senha);
  
    //        if(empresarios.findAll().stream().filter(n -> n.getId()
    //        .equals(empdor.getId())).findFirst()!=null&&emprepo.findAll()
    //        .stream().filter(n -> n.getEmpresario().getId().equals(empdor.getId())).findFirst().isEmpty()){
    //            empre =emprepo.findAll().stream()
    //            .filter(n->n.getEmpresario()
    //            .equals(empdor)).findFirst().get();
    // }
    // List<Empresa> empre =  emprepo.findAll(); 
    List<Empresa> empresas = emprepo.findAll();
    for (Empresa empresa : empresas) {
        if(empresa.getEmpresario().getId().equals(empdor.getId())){
            System.out.println("empresario");
            empre = empresa;
        }else{
            System.out.println("nada");
        }
    }
    //  empre = emprepo.findById( 3L).get();
    return ResponseEntity.ok(empdor!=null);
    }



    
    @PostMapping(value = "/cadastroEm", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Empresa CadastraEstabeleci(@RequestBody Empresa empresa){
        Empresa em;
        System.out.println(empdor.getLogin() + " "+ empdor.getSenha());
        if(empdor!=null){
            em =  empresaService.CadastraEM(empresa, empdor);
            empre = em;
            return em;
        }
        else{
            return null; 
        }
    }
 
    @PostMapping(value="/Fatura", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> Fatura(@RequestBody FaturamentoMensal fatura){
        System.out.println(empre.getCNPJ());
        return ResponseEntity.ok(faturaMens.CadastraFatura(fatura, empre));
    } 
    
    @GetMapping("/FaturaAnual")
    public List<FaturamentoMensal> faturamentoAnual(){
       List<FaturamentoMensal> ref= faturaMens.pegarUltimosMeses(empre);
       return ref;
    }


    @GetMapping("/FatuAnuais")
    public List<BigDecimal> faturamentoAnualS(){
        List<BigDecimal> fatMensal = faturaMens.pegarUltimos3Anos(empre);
        if(fatMensal!=null){
            return fatMensal;
        }else{
            return null;
        }
    }
     
    @GetMapping("/Grafith")
    public List<FaturamentoMensal> Grafico(){
        return faturaMens.TotalForGrafic(empre);
    }
    

}
