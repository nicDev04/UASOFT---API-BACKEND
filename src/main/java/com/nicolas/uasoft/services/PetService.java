package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.Cliente;
import com.nicolas.uasoft.classes.Especie;
import com.nicolas.uasoft.classes.Pet;
import com.nicolas.uasoft.classes.Raca;
import com.nicolas.uasoft.dtos.requisicao.requisicaoPetDTO;
import com.nicolas.uasoft.dtos.resposta.respostaPetDTO;
import com.nicolas.uasoft.repository.ClienteRepository;
import com.nicolas.uasoft.repository.EspecieRepository;
import com.nicolas.uasoft.repository.PetRepository;
import com.nicolas.uasoft.repository.RacaRepository;

import java.util.Optional;

public class PetService {

    private final EspecieRepository especieRepository;
    private final RacaRepository racaRepository;
    private final ClienteRepository clienteRepository;
    private final PetRepository petRepository;

    public PetService(EspecieRepository especieRepository, RacaRepository racaRepository, ClienteRepository clienteRepository, PetRepository petRepository) {
        this.especieRepository = especieRepository;
        this.racaRepository = racaRepository;
        this.clienteRepository = clienteRepository;
        this.petRepository = petRepository;
    }

    public respostaPetDTO salvarPet(requisicaoPetDTO dadosPet) {

        Optional<Cliente> tutor = clienteRepository.findById(dadosPet.getClienteId());
        Optional<Especie> especiePet = especieRepository.findById(dadosPet.getEspecieId());
        Optional<Raca> racaPet = racaRepository.findById(dadosPet.getRacaId());

        if (tutor.isEmpty()) {
            throw new RuntimeException("Tutor não encontrado");
        }

        if (especiePet.isEmpty()) {
            throw new RuntimeException("Espécie não encontrada");
        }

        if (racaPet.isEmpty()) {
            throw new RuntimeException("Raça não encontrada");
        }

        Pet pet = new Pet(
                dadosPet.getNome(),
                dadosPet.getSexo(),
                dadosPet.getDataNascimento(),
                especiePet.get(),
                racaPet.get(),
                tutor.get()
        );
        Pet petCadastrado = petRepository.save(pet);

        return new respostaPetDTO (
                petCadastrado.getIdPet(),
                petCadastrado.getNomePet(),
                petCadastrado.getSexoPet(),
                petCadastrado.getDataNascPet(),
                petCadastrado.getEspecie().getNomeEspecie(),
                petCadastrado.getRaca().getNomeRaca(),
                petCadastrado.getCliente().getNomeC()
        );
    }


}
