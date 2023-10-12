package com.solucao.cadempresas.Services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.solucao.cadempresas.Model.Empresa;
import com.solucao.cadempresas.Model.Empresario;
import com.solucao.cadempresas.Repository.EmpresaRepo;
import com.solucao.cadempresas.Repository.EmpresarioRepo;
@Component
public class EmpresaService implements EmpresaIM{
    
    @Autowired
    private EmpresaRepo empresaRepo;
    @Autowired
    private EmpresarioRepo empresarioRepo;

    public Empresa Consulta(Empresario empresario){
        Optional <Empresa> emp;
        emp = empresaRepo.findAll().stream().filter(n -> n.getEmpresario().getId().equals(empresario.getId())).findFirst();
        if(emp.isPresent()){
            return emp.get();
        }else{
            throw new RuntimeException("Não foi encontrado");
        }
    }

    @Override
    public Empresa CadastraEM(Empresa empresa, Empresario empr) {
        // TODO Auto-generated method stub
        if(empresa.getEmpresario()==null){
            empresa.setEmpresario(empr); 
        }
            // if(empresa.getEmpresario().getId().equals(empr.getId())){
            //     Long id = empresaRepo.findAll().stream()
            //     .filter(n->n.getCNPJ().
            //     equals(empresa.getCNPJ()))
            //     .findFirst()
            //     .orElseThrow().getId();
            //     if(id!=null){
            //         System.out.println(id);
            //         empresaRepo.findById(id);
            //     }else{
            //         throw new NoSuchElementException("Não há um id para esse empresario");
            //     }
            // }
        
        return empresaRepo.save(empresa);   
    }
    
}
