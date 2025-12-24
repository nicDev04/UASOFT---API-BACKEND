package com.nicolas.uasoft_refatoracao.DAO;

import com.nicolas.uasoft_refatoracao.classes.Cliente;
import com.nicolas.uasoft_refatoracao.classes.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public static void cadastrarCliente(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println("Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao inserir o cadastro no banco!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public static List<Cliente> listarClientes() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Cliente> listaCliente = new ArrayList<>();
        Query consulta;

        try {
            consulta = em.createQuery("SELECT cliente FROM Cliente cliente");
            listaCliente = consulta.getResultList();

            return listaCliente;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação para lista");
        }

        return listaCliente;
    }

    public static Cliente listarCliente(Long idCliente) {
        EntityManager em = JPAUtil.getEntityManager();
        Cliente cliente = new Cliente();

        try {
            cliente = em.find(Cliente.class, idCliente);

            return cliente;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação de cliente");
        }
        return cliente;
    }

     public static void editarCliente(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(cliente);
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
