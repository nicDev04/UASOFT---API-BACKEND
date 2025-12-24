package com.nicolas.uasoft_refatoracao.DAO;

import com.nicolas.uasoft_refatoracao.classes.Especie;
import com.nicolas.uasoft_refatoracao.classes.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EspecieDAO {

    public static List<Especie> listarEspecies() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Especie> listaEspecie = new ArrayList<>();
        Query consulta;

        try {
            consulta = em.createQuery("SELECT especie FROM Especie especie");
            listaEspecie = consulta.getResultList();

            return listaEspecie;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação para lista");
        }
        return listaEspecie;
    }
    
    public static Especie listarEspecie(Long idEspecie) {
        EntityManager em = JPAUtil.getEntityManager();
        Especie especie = new Especie();

        try {
            especie = em.find(Especie.class, idEspecie);

            return especie;
        } catch (Exception e) {
            System.out.println("Erro as buscar especie");
        }

        return especie;
    }
}
