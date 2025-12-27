package com.nicolas.uasoft.repository;

import com.nicolas.uasoft.classes.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository  extends JpaRepository<Venda, Long> {
}
