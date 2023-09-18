package com.solucao.cadempresas.Services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
        fatura.setEmpresa(empresa);
        return invoicing.save(fatura)!=null;
    }

    public List<BigDecimal> pegarUltimosMeses(Long empresaId){
        return invoicing.Encontra(empresaId);//empresaRepo.findAll()
    }

    public List<BigDecimal> pegarUltimos3Anos(Long empresaId){
        List<FaturamentoMensal> Anual = invoicing.findAll();
        Collections.sort(Anual, new Comparator<FaturamentoMensal>(){

            @Override
            public int compare(FaturamentoMensal m1,FaturamentoMensal m2) {
                return m1.getAno().compareTo(m2.getAno());
            }
        });
        List<BigDecimal> novList = new ArrayList<>();
        int ano=2023;
        for(FaturamentoMensal year:Anual){
            BigDecimal sum= BigDecimal.ZERO;
            String p = Integer.toString(ano);
            if(year.getAno().equals(p)){
                 sum=sum.add(year.getFaturamento());
            }else{
               novList.add(sum); 
               ano++; 
            }
        }
        return novList;
    }
    
}
