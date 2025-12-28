package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.classes.Pet;
import com.nicolas.uasoft.dtos.requisicao.requisicaoPetDTO;
import com.nicolas.uasoft.dtos.resposta.respostaPetDTO;
import com.nicolas.uasoft.services.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<?> salvarPet(@RequestBody requisicaoPetDTO dadosPet) {
        respostaPetDTO pet = petService.salvarPet(dadosPet);

        Map<String, Object> response = new HashMap<>();

        if (pet != null) {
            response.put("mensagem", "Pet cadastrado com sucesso");
            response.put("pet", pet);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.put("mensagem", "erro ao cadastrar pet");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPet(@PathVariable Long id) {
        respostaPetDTO pet = petService.listarPet(id);

        Map<String, Object> response = new HashMap<>();

        if (pet != null) {
            response.put("mensagem", "Pet encontrado");
            response.put("pet", pet);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "Pet não encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosPets() {
        List<respostaPetDTO> listaPets = petService.listarPets();

        Map<String, Object> response = new HashMap<>();

        if (listaPets != null && !listaPets.isEmpty()) {
            response.put("mensagem", "Pets encontrados");
            response.put("pets", listaPets);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "Nenhum pet encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarPet(@PathVariable Long id, @RequestBody requisicaoPetDTO dadosPet) {
        try {
            respostaPetDTO petEditado = petService.editarPet(id, dadosPet);

            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", "Pet editado com sucesso");
            response.put("pet", petEditado);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tutor/{idTutor}")
    public ResponseEntity<?> listarPorTutor(@PathVariable Long idTutor) {
        List<respostaPetDTO> pets = petService.findByTutorId(idTutor);

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("pets", pets);

        return ResponseEntity.ok(resposta);
    }
}
