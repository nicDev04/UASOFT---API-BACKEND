package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.classes.Cliente;
import com.nicolas.uasoft.dtos.requisicao.requisicaoClienteDTO;
import com.nicolas.uasoft.dtos.resposta.respostaClienteDTO;
import com.nicolas.uasoft.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<?> salvarCliente(@RequestBody requisicaoClienteDTO dadosCliente){
        respostaClienteDTO cliente = clienteService.salvarCliente(dadosCliente);

        Map<String, Object> response = new HashMap<>();

        if (cliente != null) {
            response.put("mensagem", "cliente cadastrado com sucesso");
            response.put("cliente", cliente);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.put("mensagem", "erro ao cadastrar cliente");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCliente(@PathVariable Long id) {
        respostaClienteDTO cliente = clienteService.buscarCliente(id);

        Map<String, Object> response = new HashMap<>();

        if (cliente != null) {
            response.put("mensagem", "cliente encontrado");
            response.put("cliente", cliente);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "cliente não encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
