package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.Grupo;
import com.nicolas.uasoft.classes.Marca;
import com.nicolas.uasoft.classes.Produto;
import com.nicolas.uasoft.dtos.requisicao.requisicaoProdutoDTO;
import com.nicolas.uasoft.dtos.resposta.respostaProdutoDTO;
import com.nicolas.uasoft.repository.GrupoRepository;
import com.nicolas.uasoft.repository.MarcaRepository;
import com.nicolas.uasoft.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
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

    public respostaProdutoDTO editar(Long id, requisicaoProdutoDTO dadosProduto) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }

        Optional<Grupo> grupo = grupoRepository.findById(dadosProduto.getGrupoId());
        Optional<Marca> marca = marcaRepository.findById(dadosProduto.getMarcaId());

        if (marca.isEmpty()) {
            throw new RuntimeException("Marca não encontrada");
        }

        if (grupo.isEmpty()) {
            throw new RuntimeException("Grupo não encontrado");
        }

        Produto produtoEditar = produtoOptional.get();

        produtoEditar.setGrupo(grupo.get());
        produtoEditar.setMarca(marca.get());
        produtoEditar.setNomeProd(dadosProduto.getNome());
        produtoEditar.setValorProd(dadosProduto.getValor());
        produtoEditar.setUnVenda(dadosProduto.getUnVenda());
        produtoEditar.setDescricaoProd(dadosProduto.getDescricao());

        Produto produtoEditado = produtoRepository.save(produtoEditar);

        return new respostaProdutoDTO (
                produtoEditado.getIdProduto(),
                produtoEditado.getNomeProd(),
                produtoEditado.getMarca().getNomeMarca(),
                produtoEditado.getGrupo().getNomeGrupo(),
                produtoEditado.getDescricaoProd(),
                produtoEditado.getUnVenda(),
                produtoEditado.getValorProd()
        );
    }

    public List<respostaProdutoDTO> listarProdutos() {
        List<respostaProdutoDTO> listaDadosProdutos = new ArrayList<>();
        List<Produto> listaProdutos = produtoRepository.findAll();

        for (Produto produto : listaProdutos) {
            listaDadosProdutos.add( new respostaProdutoDTO (
                    produto.getIdProduto(),
                    produto.getNomeProd(),
                    produto.getMarca().getNomeMarca(),
                    produto.getGrupo().getNomeGrupo(),
                    produto.getDescricaoProd(),
                    produto.getUnVenda(),
                    produto.getValorProd()
            ));
        }
        return listaDadosProdutos   ;
    }


    public respostaProdutoDTO listarFuncionario(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();

            return  new respostaProdutoDTO (
                    produto.getIdProduto(),
                    produto.getNomeProd(),
                    produto.getMarca().getNomeMarca(),
                    produto.getGrupo().getNomeGrupo(),
                    produto.getDescricaoProd(),
                    produto.getUnVenda(),
                    produto.getValorProd()
            );
        }
        return null;
    }
}
