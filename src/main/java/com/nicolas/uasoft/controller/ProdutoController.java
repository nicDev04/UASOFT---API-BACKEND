package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.dtos.requisicao.requisicaoProdutoDTO;
import com.nicolas.uasoft.dtos.resposta.respostaProdutoDTO;
import com.nicolas.uasoft.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<?> salvarProduto(@RequestBody requisicaoProdutoDTO dadosProduto) {
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

    @GetMapping
    public ResponseEntity<?> listarTodosProdutos() {
        List<respostaProdutoDTO> produtos = produtoService.listarProdutos();

        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Produtos encontrados");
        response.put("produtos", produtos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarProduto(@PathVariable Long id, @RequestBody requisicaoProdutoDTO dadosProduto) {
        try {
            respostaProdutoDTO produto = produtoService.editar(id, dadosProduto);

            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", "Produto atualizado com sucesso");
            response.put("produto", produto);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        respostaProdutoDTO produto = produtoService.listarFuncionario(id);

        Map<String, Object> response = new HashMap<>();

        if (produto != null) {
            response.put("mensagem", "Produto atualizado com sucesso");
            response.put("produto", produto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "Produto não encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
