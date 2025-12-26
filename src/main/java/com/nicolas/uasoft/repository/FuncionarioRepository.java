package com.nicolas.uasoft.repository;

import com.nicolas.uasoft.classes.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {
}
