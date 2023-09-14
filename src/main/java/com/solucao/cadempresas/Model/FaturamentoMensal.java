package com.solucao.cadempresas.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class FaturamentoMensal {
    private Empresa empresa;
    private LocalDate mesAno;
    private BigDecimal faturamento;
 
 
 
 
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public LocalDate getMes() {
        return mesAno;
    }
    public void setMes(LocalDate mesAno) {
        this.mesAno = mesAno;
    }
    public BigDecimal getFaturamento() {
        return faturamento;
    }
    public void setFaturamento(BigDecimal faturamento) {
        this.faturamento = faturamento;
    }

}
