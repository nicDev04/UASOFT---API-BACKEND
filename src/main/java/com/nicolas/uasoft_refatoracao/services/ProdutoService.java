package com.nicolas.uasoft_refatoracao.services;

import com.nicolas.uasoft_refatoracao.DAO.GrupoDAO;
import com.nicolas.uasoft_refatoracao.DAO.MarcaDAO;
import com.nicolas.uasoft_refatoracao.DAO.ProdutoDAO;
import com.nicolas.uasoft_refatoracao.classes.Grupo;
import com.nicolas.uasoft_refatoracao.classes.Marca;
import com.nicolas.uasoft_refatoracao.classes.Produto;
import com.nicolas.uasoft_refatoracao.dtos.requisicao.requisicaoProdutoDTO;

public class ProdutoService {
    
    private MarcaDAO marcaDAO;
    private GrupoDAO grupoDAO;
    private ProdutoDAO produtoDAO;

    public ProdutoService(MarcaDAO marcaDAO, GrupoDAO grupoDAO, ProdutoDAO produtoDAO) {
        this.marcaDAO = marcaDAO;
        this.grupoDAO = grupoDAO;
        this.produtoDAO = produtoDAO;
    }
    
    public void salvarProduto(requisicaoProdutoDTO dadosProduto) {
        
        Grupo grupo = grupoDAO.listarGrupo(dadosProduto.getGrupoId());
        Marca marca = marcaDAO.listarMarca(dadosProduto.getMarcaId());
        
        Produto produto = new Produto(
                dadosProduto.getNome(),
                dadosProduto.getUnVenda(),
                dadosProduto.getValor(),
                dadosProduto.getDescricao()
        );
        
        produto.setMarca(marca);
        produto.setGrupo(grupo);
        
        produtoDAO.cadastrarProduto(produto);
    }
}
