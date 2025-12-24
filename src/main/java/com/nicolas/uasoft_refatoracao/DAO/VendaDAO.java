package com.nicolas.uasoft_refatoracao.DAO;

import com.nicolas.uasoft_refatoracao.classes.JPAUtil;
import com.nicolas.uasoft_refatoracao.classes.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public static void cadastrarVenda(Venda venda) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
            System.out.println("Venda cadastrada com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao inserir o cadastro no banco!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public static List<Venda> listarVendas() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Venda> listaVendas = new ArrayList<>();
        Query consulta;

        try {
            consulta = em.createQuery("SELECT venda FROM Venda venda");
            listaVendas = consulta.getResultList();

            return listaVendas;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação para lista");
        }

        return listaVendas;
    }
    
     public static Venda listarVenda(String idVenda) {
        EntityManager em = JPAUtil.getEntityManager();
        Venda venda = new Venda();
        
        try {
            venda = em.find(Venda.class, idVenda);
            
            return venda;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação da venda");
        }
        
        return venda;
    }
    
    public static void editarVenda(Venda venda) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(venda);
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
