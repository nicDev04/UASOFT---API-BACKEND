package com.nicolas.uasoft_refatoracao.DAO;

import com.nicolas.uasoft_refatoracao.classes.Cliente;
import com.nicolas.uasoft_refatoracao.classes.JPAUtil;
import com.nicolas.uasoft_refatoracao.classes.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

    public static void cadastrarPet(Pet pet) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pet);
            em.getTransaction().commit();
            System.out.println("Pet cadastrado com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao inserir o cadastro no banco!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    public static List<Pet> listarPets() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Pet> listaPets = new ArrayList<>();
        Query consulta;

        try {
                consulta = em.createQuery("SELECT pet FROM Pet pet");
                listaPets = consulta.getResultList();

            return listaPets;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação para lista");
        }

        return listaPets;
    }
    
    public static List<Pet> listarPetsCliente(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Pet> listaPetCliente = new ArrayList<>();
        TypedQuery<Pet>  consulta;

        try {
                consulta = em.createQuery("SELECT pet FROM Pet pet WHERE pet.cliente = :cliente", Pet.class);
                consulta.setParameter("cliente", cliente);
                listaPetCliente = consulta.getResultList();

            return listaPetCliente;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação para lista");
        }

        return listaPetCliente;
    }
    
    public static Pet listarPet(String idPet) {
        EntityManager em = JPAUtil.getEntityManager();
        Pet pet = new Pet();

        try {
            pet = em.find(Pet.class, idPet);

            return pet;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação do pet");
        }

        return pet;
    }
    
    public static void editarPet(Pet pet) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(pet);
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
