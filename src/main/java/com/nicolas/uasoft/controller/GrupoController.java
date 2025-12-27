package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.classes.Grupo;
import com.nicolas.uasoft.dtos.resposta.respostaClienteDTO;
import com.nicolas.uasoft.dtos.resposta.respostaGrupoDTO;
import com.nicolas.uasoft.repository.GrupoRepository;
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
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoRepository grupoRepository;

    public GrupoController(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    @GetMapping
    public ResponseEntity<?> buscarGrupos() {
        List<Grupo> grupos = grupoRepository.findAll();

        List<respostaGrupoDTO> dadosGrupos = new ArrayList<>();

        for (Grupo grupo : grupos) {
            respostaGrupoDTO grupoDTO = new respostaGrupoDTO(grupo.getIdGrupo(), grupo.getNomeGrupo());

            dadosGrupos.add(grupoDTO);
        }

        Map<String, Object> response = new HashMap<>();

        if (!dadosGrupos.isEmpty()) {
            response.put("mensagem", "Grupos encontrados");
            response.put("grupos", dadosGrupos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "Grupos não encontrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
