package com.nicolas.uasoft_refatoracao.DAO;

import com.nicolas.uasoft_refatoracao.classes.Funcionario;
import com.nicolas.uasoft_refatoracao.classes.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public static void cadastrarFuncionario(Funcionario funcionario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
            System.out.println("Funcionario cadastrado com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao inserir o cadastro no banco!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public static Funcionario listarFuncionario(Long idFuncionario) {
        EntityManager em = JPAUtil.getEntityManager();
        Funcionario funcionario = new Funcionario();
        
        try {
            funcionario = em.find(Funcionario.class, idFuncionario);
            
            return funcionario;
        } catch (Exception e) {
            System.out.println("Erro ao listar o funcionário no banco!");
        }
        return funcionario;
    }

    public static List<Funcionario> listarFuncionarios() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        Query consulta;

        try {
            consulta = em.createQuery("SELECT funcionario FROM Funcionario funcionario");
            listaFuncionarios = consulta.getResultList();

            return listaFuncionarios;
        } catch (Exception e) {
            System.out.println( "Erro as buscar informação para lista");
        }

        return listaFuncionarios;
    }
    
    public static List<Funcionario> listarVeterinario() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Funcionario> listaVet = new ArrayList<>();
        TypedQuery consulta;

        try {
            consulta = em.createQuery("SELECT funcionario FROM Funcionario funcionario WHERE funcionario.cargoF = :cargo", Funcionario.class);
            consulta.setParameter("cargo", "Veterinário");
            listaVet = consulta.getResultList();

            return listaVet;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação para lista");
            
        }

        return listaVet;
    }
    
    public static void editarFuncionario(Funcionario funcionario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(funcionario);
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
