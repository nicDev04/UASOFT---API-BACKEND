package com.nicolas.uasoft.services;

import com.nicolas.uasoft_refatoracao.DAO.ClienteDAO;
import com.nicolas.uasoft_refatoracao.DAO.EspecieDAO;
import com.nicolas.uasoft_refatoracao.DAO.PetDAO;
import com.nicolas.uasoft_refatoracao.DAO.RacaDAO;
import com.nicolas.uasoft_refatoracao.classes.Cliente;
import com.nicolas.uasoft_refatoracao.classes.Especie;
import com.nicolas.uasoft_refatoracao.classes.Pet;
import com.nicolas.uasoft_refatoracao.classes.Raca;
import com.nicolas.uasoft_refatoracao.dtos.requisicao.requisicaoPetDTO;

public class PetService {
    
    private EspecieDAO especieDAO;
    private RacaDAO racaDAO;
    private ClienteDAO clienteDAO;
    private PetDAO petDAO;

    public PetService(EspecieDAO especieDAO, RacaDAO racaDAO, ClienteDAO clienteDAO, PetDAO petDAO) {
        this.especieDAO = especieDAO;
        this.racaDAO = racaDAO;
        this.clienteDAO = clienteDAO;
        this.petDAO = petDAO;
    }
    
    public void salvarPet(requisicaoPetDTO dadosPet) {

        Cliente tutor = clienteDAO.listarCliente(dadosPet.getClienteId());
        Especie especiePet = EspecieDAO.listarEspecie(dadosPet.getEspecieId());
        Raca racaPet = racaDAO.listarRaca(dadosPet.getRacaId());
        
        Pet pet = new Pet(
                dadosPet.getNome(),
                dadosPet.getSexo(),
                dadosPet.getDataNascimento(),
                especiePet,
                racaPet,
                tutor
        );
        petDAO.cadastrarPet(pet);     
    }
    
    
    
}
