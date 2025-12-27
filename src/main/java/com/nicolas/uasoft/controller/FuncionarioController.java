package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.dtos.requisicao.requisicaoFuncionarioDTO;
import com.nicolas.uasoft.dtos.resposta.respostaFuncionarioDTO;
import com.nicolas.uasoft.services.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<?> salvarCliente(@RequestBody requisicaoFuncionarioDTO dadosFuncionario) {
        respostaFuncionarioDTO funcionario = funcionarioService.salvarFuncionario(dadosFuncionario);

        Map<String, Object> response = new HashMap<>();

        if (funcionario != null) {
            response.put("mensagem", "Funcionário cadastrado com sucesso");
            response.put("funcionario", funcionario);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.put("mensagem", "erro ao cadastrar funcionário");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
