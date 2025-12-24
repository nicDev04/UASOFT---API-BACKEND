package com.nicolas.uasoft_refatoracao.DAO;

import com.nicolas.uasoft_refatoracao.classes.Grupo;
import com.nicolas.uasoft_refatoracao.classes.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAO {

    public static List<Grupo> listarGrupos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Grupo> listaGrupos = new ArrayList<>();
        Query consulta;

        try {
            consulta = em.createQuery("SELECT grupo FROM Grupo grupo");
            listaGrupos = consulta.getResultList();

            return listaGrupos;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação para lista");
        }

        return listaGrupos;
    }
    
    public static Grupo listarGrupo(Long idGrupo) {
        EntityManager em = JPAUtil.getEntityManager();
        Grupo grupo = new Grupo();

        try {
            grupo = em.find(Grupo.class, idGrupo);

            return grupo;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação do grupo");
        }
        return grupo;
    }
}
