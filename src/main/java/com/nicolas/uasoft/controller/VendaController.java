package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.dtos.requisicao.requisicaoVendaDTO;
import com.nicolas.uasoft.dtos.resposta.respostaVendaDTO;
import com.nicolas.uasoft.services.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<?> salvarVenda(@RequestBody requisicaoVendaDTO dadosVenda) {
        try {

            respostaVendaDTO venda = vendaService.salvarVenda(dadosVenda);

            Map<String, Object> response = new HashMap<>();

            if (venda != null) {
                response.put("mensagem", "Venda realizada com sucesso");
                response.put("venda", venda);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                response.put("mensagem", "Erro ao processar venda");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

        } catch (RuntimeException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("mensagem", "Erro ao cadastrar venda");
            errorResponse.put("erro", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
