package com.solucao.cadempresas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solucao.cadempresas.Model.Empresa;

public interface EmpresaRepo extends JpaRepository<Empresa,Long> {
    
}
