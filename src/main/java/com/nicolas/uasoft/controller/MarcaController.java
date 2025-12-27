package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.classes.Grupo;
import com.nicolas.uasoft.classes.Marca;
import com.nicolas.uasoft.dtos.resposta.respostaGrupoDTO;
import com.nicolas.uasoft.repository.MarcaRepository;
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
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaRepository marcaRepository;

    public MarcaController(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @GetMapping
    public ResponseEntity<?> buscarMarcas() {
        List<Marca> marcas = marcaRepository.findAll();

        List<respostaGrupoDTO> dadosMarcas = new ArrayList<>();

        for (Marca marca : marcas) {
            respostaGrupoDTO grupoDTO = new respostaGrupoDTO(marca.getIdMarca(), marca.getNomeMarca());

            dadosMarcas.add(grupoDTO);
        }

        Map<String, Object> response = new HashMap<>();

        if (!dadosMarcas.isEmpty()) {
            response.put("mensagem", "Marcas encontradas");
            response.put("marcas", dadosMarcas);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "Marcas não encontradas");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
