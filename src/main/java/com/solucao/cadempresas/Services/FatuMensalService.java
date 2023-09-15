package com.solucao.cadempresas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.solucao.cadempresas.Model.Empresa;
import com.solucao.cadempresas.Model.FaturamentoMensal;
import com.solucao.cadempresas.Repository.EmpresaRepo;
import com.solucao.cadempresas.Repository.FatuRepo;
@Component
public class FatuMensalService implements FatuMensalIM{


    @Autowired
    private FatuRepo invoicing;
    @Autowired 
    private EmpresaRepo empresaRepo;

    @Override
    public List<FaturamentoMensal> consultaFat(String CNPJ) {
        // TODO Auto-generated method stub
        return invoicing.findAll()
        .stream()
        .filter(n -> n.getEmpresa().getCNPJ().equals(CNPJ))
        .toList();
    }


    @Override
    public Boolean CadastraFatura(FaturamentoMensal fatura, Empresa empresa) {
        
        Optional<Empresa> emp =  empresaRepo.findById(empresa.getId());
        if(emp.isEmpty()){
            throw new RuntimeException("Empresa não cadastrada");
        }
        List<FaturamentoMensal> faturamentos = emp.get().getFatura();
        faturamentos.add(fatura);
        empresaRepo.save(emp.get());
        return invoicing.save(fatura)!=null;
    }
    
}
