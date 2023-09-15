package com.solucao.cadempresas.Services;

import java.util.List;

import com.solucao.cadempresas.Model.Empresa;
import com.solucao.cadempresas.Model.FaturamentoMensal;

public interface FatuMensalIM {
    public List<FaturamentoMensal> consultaFat(String CNPJ);
    public Boolean CadastraFatura(FaturamentoMensal fatura, Empresa empresa);
}
