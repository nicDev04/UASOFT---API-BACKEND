package com.nicolas.uasoft.services;

import com.nicolas.uasoft_refatoracao.DAO.RacaDAO;

public class RacaService {
    
    private RacaDAO racaDAO;

    public RacaService(RacaDAO racaDAO) {
        this.racaDAO = racaDAO;
    }
    
}
