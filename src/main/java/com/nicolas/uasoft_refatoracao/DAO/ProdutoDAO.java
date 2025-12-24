package com.nicolas.uasoft_refatoracao.DAO;

import com.nicolas.uasoft_refatoracao.classes.JPAUtil;
import com.nicolas.uasoft_refatoracao.classes.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public static void cadastrarProduto(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
            System.out.println("Produto cadastrado com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
           System.out.println("Erro ao inserir o cadastro no banco!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public static List<Produto> listarProdutos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Produto> listaProdutos = new ArrayList<>();
        Query consulta;

        try {
            consulta = em.createQuery("SELECT produto FROM Produto produto");
            listaProdutos = consulta.getResultList();

            return listaProdutos;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação para lista");
        }

        return listaProdutos;
    }
    
    public static Produto listarProduto(String idProduto) {
        EntityManager em = JPAUtil.getEntityManager();
        Produto produto = new Produto();

        try {
            produto = em.find(Produto.class, idProduto);

            return produto;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação do produto");
        }

        return produto;
    }

     public static void editarProduto(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
            System.out.println("Edição realizada com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
           System.out.println("Ocorreu um erro ao editar as informações");
        } finally {
            em.close();
        }
    }
    
}
