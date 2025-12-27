package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.dtos.requisicao.requisicaoFuncionarioDTO;
import com.nicolas.uasoft.dtos.requisicao.requisicaoPetDTO;
import com.nicolas.uasoft.dtos.resposta.respostaFuncionarioDTO;
import com.nicolas.uasoft.dtos.resposta.respostaPetDTO;
import com.nicolas.uasoft.services.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<?> salvarFuncionario(@RequestBody requisicaoFuncionarioDTO dadosFuncionario) {
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

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarFuncionario(@PathVariable Long id) {
        respostaFuncionarioDTO funcionario = funcionarioService.listarFuncionario(id);

        Map<String, Object> response = new HashMap<>();

        if (funcionario != null) {
            response.put("mensagem", "funcionário encontrado");
            response.put("funcionario", funcionario);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "funcionário não encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarFuncionarios() {
        List<respostaFuncionarioDTO> dadosFuncionarios = funcionarioService.listarFuncionarios();

        Map<String, Object> response = new HashMap<>();

        if (dadosFuncionarios != null) {
            response.put("mensagem", "funcionários encontrados");
            response.put("funcionarios", dadosFuncionarios);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "funcionários não encontrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarFuncionario(@PathVariable Long id, @RequestBody requisicaoFuncionarioDTO dadosFuncionario) {
        try {
            respostaFuncionarioDTO funcionarioEditado = funcionarioService.editarFuncionario(id, dadosFuncionario);

            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", "Funcionário editado com sucesso");
            response.put("funcionario", funcionarioEditado);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


}
