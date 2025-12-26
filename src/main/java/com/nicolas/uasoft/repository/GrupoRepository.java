package com.nicolas.uasoft.repository;

import com.nicolas.uasoft.classes.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository  extends JpaRepository<Grupo, Long> {
}
