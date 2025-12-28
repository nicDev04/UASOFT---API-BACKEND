package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.dtos.resposta.respostaRacaDTO;
import com.nicolas.uasoft.services.RacaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/racas")
public class RacaController {

    private final RacaService racaService;

    public RacaController(RacaService racaService) {
        this.racaService = racaService;
    }

    @GetMapping("/especie/{idEspecie}")
    public ResponseEntity<?> listarRacasPorEspecie(@PathVariable Long idEspecie) {
        Map<String, Object> response = new HashMap<>();
        List<respostaRacaDTO> racas = racaService.listarRacas(idEspecie);

        if (!racas.isEmpty()) {
            response.put("mensagem", "Raças encontradas para a espécie informada");
            response.put("racas", racas);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "Nenhuma raça cadastrada para esta espécie");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
