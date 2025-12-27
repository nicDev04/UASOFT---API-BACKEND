package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.classes.Especie;
import com.nicolas.uasoft.dtos.resposta.respostaClienteDTO;
import com.nicolas.uasoft.dtos.resposta.respostaEspecieDTO;
import com.nicolas.uasoft.repository.EspecieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("especies")
public class EspecieController {

    private final EspecieRepository especieRepository;

    public EspecieController(EspecieRepository especieRepository) {
        this.especieRepository = especieRepository;
    }

    @GetMapping
    public ResponseEntity<?> buscarEspecies() {
        List<Especie> especies = especieRepository.findAll();
        List<respostaEspecieDTO> dadosEspecies = new ArrayList<>();

        for (Especie especie : especies) {
            respostaEspecieDTO especieDto  = new respostaEspecieDTO(especie.getIdEspecie(), especie.getNomeEspecie());
            dadosEspecies.add(especieDto);
        }

        Map<String, Object> response = new HashMap<>();

        if (!dadosEspecies.isEmpty()) {
            response.put("mensagem", "Espécies encontradas");
            response.put("especies", dadosEspecies);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "Espécies não encontradas");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
