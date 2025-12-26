package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.classes.Cliente;
import com.nicolas.uasoft.dtos.requisicao.requisicaoClienteDTO;
import com.nicolas.uasoft.dtos.resposta.respostaClienteDTO;
import com.nicolas.uasoft.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

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
}
