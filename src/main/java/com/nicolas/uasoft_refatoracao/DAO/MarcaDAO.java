package com.nicolas.uasoft_refatoracao.DAO;


import com.nicolas.uasoft_refatoracao.classes.JPAUtil;
import com.nicolas.uasoft_refatoracao.classes.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAO {

    public static List<Marca> listarMarcas() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Marca> listaMarcas = new ArrayList<>();
        Query consulta;

        try {
            consulta = em.createQuery("SELECT marca FROM Marca marca");
            listaMarcas = consulta.getResultList();

            return listaMarcas;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação para lista");
        }

        return listaMarcas;
    }
    
    public static Marca listarMarca(Long idMarca) {
        EntityManager em = JPAUtil.getEntityManager();
        Marca marca = new Marca();

        try {
            marca = em.find(Marca.class, idMarca);

            return marca;
        } catch (Exception e) {
            System.out.println("Erro as buscar informação da marca");
        }
        return marca;
    }
}
