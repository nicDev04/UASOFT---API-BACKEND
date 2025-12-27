package com.nicolas.uasoft.repository;

import com.nicolas.uasoft.classes.Especie;
import com.nicolas.uasoft.classes.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long> {
    @Query("SELECT raca FROM Raca raca WHERE raca.especie = :especie")
    List<Raca > listarRacas(Especie especie);
}
