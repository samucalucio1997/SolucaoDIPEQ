package com.solucao.cadempresas.Services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    
    public List<FaturamentoMensal> pegarUltimosMeses(Empresa empresaId){
        List<FaturamentoMensal> ultimos;
        if(empresaId==null){
            System.out.println("Não há empresa cadastrada");
            ultimos = new ArrayList<>();
            return ultimos;
        }
        ultimos = invoicing.findAll().stream().filter(n->n.getEmpresa()
        .getId().equals(empresaId.getId())).toList();

        // Collections.sort(ultimos, new Comparator<FaturamentoMensal>() {
        //     @Override
        //     public int compare(FaturamentoMensal arg0, FaturamentoMensal arg1) {
        //          return arg0.getMes().compareTo(arg1.getMes());
        //     }            
        // });
        return ultimos.subList(ultimos.size()-3, ultimos.size());
    }

    public List<BigDecimal> pegarUltimos3Anos(Empresa empresaId){
        List<FaturamentoMensal> Anual ;
        if(empresaId!=null){
            Anual = invoicing.findAll().stream()
        .filter(n->n.getEmpresa().getId().equals(empresaId.getId())).toList();
        }else{
            Anual = new ArrayList<>();
        }
        // if(Anual!=null){
        //     Collections.sort(Anual, new Comparator<FaturamentoMensal>() {
        //         @Override
        //         public int compare(FaturamentoMensal str1, FaturamentoMensal str2) {
        //             int num1 = Integer.parseInt(str1.getAno());
        //             int num2 = Integer.parseInt(str2.getAno());
        //             return Integer.compare(num1, num2);
        //         }
        //     });    
        // }else{
        //     throw new RuntimeException("lista vazia");
        // }
        List<BigDecimal> novList = new ArrayList<>();
    
        if(Anual.size()!=0){
            int c=Anual.size();
            BigDecimal sum= BigDecimal.ZERO;
            int k =Integer.parseInt(Anual.get(0).getAno());
                for (FaturamentoMensal fat : Anual) {
                   String m = Integer.toString(k);
                //  System.out.println(fat.getAno() + " " + m);
                   if(fat.getAno().equals(m)){
                //  System.out.println(fat.getAno()); 
                      sum = sum.add(fat.getFaturamento());
                      c--;
                      if(c==1){
                        // System.out.println(sum.doubleValue());
                        novList.add(sum); 
                      }
                      continue;
                    }
                    // System.out.println(sum.doubleValue());
                    novList.add(sum); 
                    k++;
                    sum = BigDecimal.ZERO;
                }
            }
            return novList;
    }

    public List<FaturamentoMensal> TotalForGrafic(Empresa emp){
        return invoicing.findAll().stream().filter(n->n.getEmpresa().getId()
        .equals(emp.getId())).toList();
    }
    
}

// int ano=2023;
// for(FaturamentoMensal year:Anual){
//     String p = Integer.toString(ano);
//     if(c==0){break;}
//     if(year.getAno().equals(p)){
//          sum=sum.add(year.getFaturamento());
//          System.out.println(sum);
//     }else{
//        novList.add(sum); 
//        c--;
//        ano--; 
//     }
// }