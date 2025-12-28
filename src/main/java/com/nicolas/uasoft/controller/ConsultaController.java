package com.nicolas.uasoft.controller;

import com.nicolas.uasoft.dtos.requisicao.requisicaoConsultaDTO;
import com.nicolas.uasoft.dtos.resposta.respostaConsultaDTO;
import com.nicolas.uasoft.dtos.resposta.respostaVendaDTO;
import com.nicolas.uasoft.services.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private  final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<?> salvarConsulta(@RequestBody requisicaoConsultaDTO dadosConsulta) {
        try {
            respostaConsultaDTO consulta = consultaService.salvarConsulta(dadosConsulta);

            Map<String, Object> response = new HashMap<>();

            if (consulta != null) {
                response.put("mensagem", "Consulta cadastrada com sucesso");
                response.put("consulta", consulta);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                response.put("mensagem", "Erro ao cadastrar consulta");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

        } catch (RuntimeException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("mensagem", "Erro ao cadastrar consulta");
            errorResponse.put("erro", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarConsultas() {
        List<respostaConsultaDTO> dadosVendas = consultaService.buscarConsultas();

        Map<String, Object> response = new HashMap<>();

        if (dadosVendas != null) {
            response.put("mensagem", "Consultas encontrados");
            response.put("vendas", dadosVendas);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensagem", "Consultas não encontrados");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }
}
