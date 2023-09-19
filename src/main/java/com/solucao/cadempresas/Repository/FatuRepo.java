package com.solucao.cadempresas.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.solucao.cadempresas.Model.FaturamentoMensal;

public interface FatuRepo extends JpaRepository<FaturamentoMensal,Long>{
    @Query(value = "select faturamento from faturamento_mensal where empresa_id=?1 and ano=?2",
    nativeQuery = true)
    List<BigDecimal> Encontra(@Param("empresa_id") Long empresa_id,String ano);
}
