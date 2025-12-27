package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.Grupo;
import com.nicolas.uasoft.classes.Marca;
import com.nicolas.uasoft.classes.Produto;
import com.nicolas.uasoft.dtos.requisicao.requisicaoProdutoDTO;
import com.nicolas.uasoft.dtos.resposta.respostaProdutoDTO;
import com.nicolas.uasoft.repository.GrupoRepository;
import com.nicolas.uasoft.repository.MarcaRepository;
import com.nicolas.uasoft.repository.ProdutoRepository;

import java.util.Optional;

public class ProdutoService {
    
    private final MarcaRepository marcaRepository;
    private final GrupoRepository grupoRepository;
    private final ProdutoRepository produtoRepository;

    public ProdutoService(MarcaRepository marcaRepository, GrupoRepository grupoRepository, ProdutoRepository produtoRepository) {
        this.marcaRepository = marcaRepository;
        this.grupoRepository = grupoRepository;
        this.produtoRepository = produtoRepository;
    }

    public respostaProdutoDTO salvarProduto(requisicaoProdutoDTO dadosProduto) {
        Optional<Grupo> grupo = grupoRepository.findById(dadosProduto.getGrupoId());
        Optional<Marca> marca = marcaRepository.findById(dadosProduto.getMarcaId());

        if (marca.isEmpty()) {
            throw new RuntimeException("Marca não encontrada");
        }

        if (grupo.isEmpty()) {
            throw new RuntimeException("Grupo não encontrado");
        }
        
        Produto produto = new Produto(
                dadosProduto.getNome(),
                dadosProduto.getUnVenda(),
                dadosProduto.getValor(),
                dadosProduto.getDescricao()
        );

        produto.setMarca(marca.get());
        produto.setGrupo(grupo.get());

        Produto produtoSalvo = produtoRepository.save(produto);

        return new respostaProdutoDTO (
                produtoSalvo.getIdProduto(),
                produtoSalvo.getNomeProd(),
                produtoSalvo.getMarca().getNomeMarca(),
                produtoSalvo.getGrupo().getNomeGrupo(),
                produtoSalvo.getDescricaoProd(),
                produtoSalvo.getUnVenda(),
                produtoSalvo.getValorProd()
        );
    }
}
