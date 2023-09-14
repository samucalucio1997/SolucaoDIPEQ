package com.solucao.cadempresas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solucao.cadempresas.Model.Empresario;

public interface EmpresarioRepo extends JpaRepository<Empresario,Long> {
    
}
