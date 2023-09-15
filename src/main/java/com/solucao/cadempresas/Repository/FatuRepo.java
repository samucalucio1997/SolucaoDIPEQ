package com.solucao.cadempresas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solucao.cadempresas.Model.FaturamentoMensal;

public interface FatuRepo extends JpaRepository<FaturamentoMensal,Long>{
    
}
