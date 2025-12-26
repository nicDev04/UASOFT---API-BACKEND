package com.nicolas.uasoft.services;

import com.nicolas.uasoft_refatoracao.DAO.EspecieDAO;
import com.nicolas.uasoft_refatoracao.classes.Especie;
import java.util.List;

public class EspecieService {
    private EspecieDAO especieDAO;

    public EspecieService(EspecieDAO especieDAO) {
        this.especieDAO = especieDAO;
    }
    
    public void listarEspecies() {
        List<Especie> especies = especieDAO.listarEspecies();
        System.out.println("--- Especies ---");
        for (Especie especie : especies) {
            
            System.out.println(especie.getNomeEspecie());
        }
    }
    
}
