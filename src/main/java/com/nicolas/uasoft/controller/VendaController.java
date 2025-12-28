package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.dtos.requisicao.requisicaoVendaDTO;
import com.nicolas.uasoft.dtos.resposta.respostaClienteDTO;
import com.nicolas.uasoft.dtos.resposta.respostaVendaDTO;
import com.nicolas.uasoft.services.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping
    public ResponseEntity<?> buscarVendas() {
        List<respostaVendaDTO> dadosVendas = vendaService.buscarVendas();

        Map<String, Object> response = new HashMap<>();

        if (dadosVendas != null) {
            response.put("mensagem", "Vendas encontrados");
            response.put("vendas", dadosVendas);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "Vendas não encontrados");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
