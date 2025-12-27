package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.Especie;
import com.nicolas.uasoft.classes.Raca;
import com.nicolas.uasoft.dtos.resposta.respostaRacaDTO;
import com.nicolas.uasoft.repository.EspecieRepository;
import com.nicolas.uasoft.repository.RacaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RacaService {

   private final RacaRepository racaRepository;
   private final EspecieRepository especieRepository;

    public RacaService(RacaRepository racaRepository, EspecieRepository especieRepository) {
        this.racaRepository = racaRepository;
        this.especieRepository = especieRepository;
    }


    public List<respostaRacaDTO> listarRacas(Long idEspecie ) {
        Optional<Especie> especie = especieRepository.findById(idEspecie);
        if (especie.isEmpty()) {
            throw new RuntimeException("Dados da espécie não encontrado");
        }

        List<Raca> listaRacas = racaRepository.listarRacas(especie.get());
        List<respostaRacaDTO> listaDadosRaca = new ArrayList<>();

        for (Raca raca : listaRacas ) {
            respostaRacaDTO dadosRaca = new respostaRacaDTO(raca.getIdRaca(), raca.getNomeRaca());
            listaDadosRaca.add(dadosRaca);
        }

        return listaDadosRaca;
    }
}
