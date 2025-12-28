package com.nicolas.uasoft.repository;

import com.nicolas.uasoft.classes.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {
    @Query("SELECT f FROM Funcionario f JOIN FETCH f.login l where l.login  = :login ")
    Funcionario  findByLogin(String login);
}
