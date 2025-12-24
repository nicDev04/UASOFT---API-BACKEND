package com.nicolas.uasoft_refatoracao.DAO;

import com.nicolas.uasoft_refatoracao.classes.Consulta;
import com.nicolas.uasoft_refatoracao.classes.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class ConsultaDAO {
    
    public static void cadastrarConsulta(Consulta consulta) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(consulta);
            em.getTransaction().commit();
            System.out.println("Consulta cadastrada com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
           System.out.println("Erro ao inserir o cadastro no banco!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public static List<Consulta> listarConsultas() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Consulta> listaConsultas = new ArrayList<>();
        Query consulta;

        try {
                consulta = em.createQuery("SELECT consulta FROM Consulta consulta");
                listaConsultas = consulta.getResultList();

            return listaConsultas;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação para lista");
        }

        return listaConsultas;
    }
    
    public static Consulta listarConsulta(String idConsulta) {
        EntityManager em = JPAUtil.getEntityManager();
        Consulta consulta = new Consulta();
        
        try {
            consulta = em.find(Consulta.class, idConsulta);
            
            return consulta;
        } catch (Exception e) {
            System.out.println("Erro ao listar a consulta no banco!");
        }
        return consulta;
    }
    
    public static void editarConsulta(Consulta consulta) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(consulta);
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
