package com.solucao.cadempresas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.solucao.cadempresas.Model.Empresa;

public interface EmpresaRepo extends JpaRepository<Empresa,Long> {
    
     @Query(value = "SELECT cnpj FROM empresa WHERE empresario_id=?1", nativeQuery = true)
    List<Empresa> consultarDadosNativos(Long id);
}
