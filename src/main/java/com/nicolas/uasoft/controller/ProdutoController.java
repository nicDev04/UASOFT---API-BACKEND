package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.dtos.requisicao.requisicaoProdutoDTO;
import com.nicolas.uasoft.dtos.resposta.respostaProdutoDTO;
import com.nicolas.uasoft.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<?> salvarCliente(@RequestBody requisicaoProdutoDTO dadosProduto) {
        respostaProdutoDTO produto = produtoService.salvarProduto(dadosProduto);

        Map<String, Object> response = new HashMap<>();

        if (produto != null) {
            response.put("mensagem", "Produto cadastrado com sucesso");
            response.put("cliente", produto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.put("mensagem", "erro ao cadastrar produto");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
