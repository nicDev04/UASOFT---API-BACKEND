package com.nicolas.uasoft_refatoracao.DAO;

import com.nicolas.uasoft_refatoracao.classes.Especie;
import com.nicolas.uasoft_refatoracao.classes.JPAUtil;
import com.nicolas.uasoft_refatoracao.classes.Raca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class RacaDAO {

    public static List<Raca> listarRacas(Especie especie) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Raca> listaRacas = new ArrayList<>();
        TypedQuery<Raca>  consulta;

        try {
                consulta = em.createQuery("SELECT raca FROM Raca raca WHERE raca.especie = :especie", Raca.class);
                consulta.setParameter("especie", especie);
                listaRacas = consulta.getResultList();

            return listaRacas;
        } catch (Exception e) {
           System.out.println("Erro as buscar informação para lista");
        }

        return listaRacas;
    }
    
    public static Raca listarRaca(Long idRaca) {
        EntityManager em = JPAUtil.getEntityManager();
        Raca raca = new Raca();

        try {
            raca = em.find(Raca.class, idRaca);

            return raca;
        } catch (Exception e) {
            System.out.println("Erro as buscar especie");
        }

        return raca;
    }
        
}
