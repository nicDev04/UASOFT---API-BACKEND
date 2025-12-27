package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.Cliente;
import com.nicolas.uasoft.classes.Produto;
import com.nicolas.uasoft.classes.Venda;
import com.nicolas.uasoft.dtos.requisicao.requisicaoVendaDTO;
import com.nicolas.uasoft.dtos.resposta.respostaVendaDTO;
import com.nicolas.uasoft.repository.ClienteRepository;
import com.nicolas.uasoft.repository.ProdutoRepository;
import com.nicolas.uasoft.repository.VendaRepository;

import java.time.LocalDate;
import java.util.Optional;

public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public VendaService(VendaRepository vendaRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public respostaVendaDTO salvarVenda(requisicaoVendaDTO dadosVenda) {
        Optional<Produto> produtoOptional = produtoRepository.findById(dadosVenda.getIdProduto());
        if (produtoOptional.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }

        Optional<Cliente> tutorOptional = clienteRepository.findById(dadosVenda.getIdTutor());
        if (tutorOptional.isEmpty()) {
            throw new RuntimeException("Tutor não encontrado");
        }

        Venda venda = new Venda(
                LocalDate.now(),
                dadosVenda.getQtdProduto(),
                dadosVenda.getTotalVenda(),
                tutorOptional.get(),
                produtoOptional.get()
        );

        Venda vendaSalva = vendaRepository.save(venda);

        return new respostaVendaDTO(
                vendaSalva.getIdVenda(),
                vendaSalva.getCliente().getNomeC(),
                vendaSalva.getProduto().getNomeProd(),
                vendaSalva.getQtdProduto(),
                vendaSalva.getTotalVenda(),
                vendaSalva.getDataVenda()
        );
    }


}
