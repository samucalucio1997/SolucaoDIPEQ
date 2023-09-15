package com.solucao.cadempresas.Services;

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

    @Override
    public Empresa CadastraEM(Empresa empresa, Empresario empr) {
        // TODO Auto-generated method stub
        if(empresa.getEmpresario()==null){
            empresa.setEmpresario(empr);    
        }
            empresarioRepo.findById(empresa.getEmpresario().getId());
            empresarioRepo.save(empr);
            empresaRepo.findById(empresa.getId());
        
        return empresaRepo.save(empresa);   
    }
    
}