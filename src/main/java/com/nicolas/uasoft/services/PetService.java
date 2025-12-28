package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.*;
import com.nicolas.uasoft.dtos.requisicao.requisicaoPetDTO;
import com.nicolas.uasoft.dtos.resposta.respostaPetDTO;
import com.nicolas.uasoft.repository.ClienteRepository;
import com.nicolas.uasoft.repository.EspecieRepository;
import com.nicolas.uasoft.repository.PetRepository;
import com.nicolas.uasoft.repository.RacaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
        if (tutor.isEmpty()) {
            throw new RuntimeException("Tutor não encontrado");
        }

        Optional<Especie> especiePet = especieRepository.findById(dadosPet.getEspecieId());
        if (especiePet.isEmpty()) {
            throw new RuntimeException("Espécie não encontrada");
        }

        Optional<Raca> racaPet = racaRepository.findById(dadosPet.getRacaId());
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
                petCadastrado.getEspecie().getIdEspecie(),
                petCadastrado.getEspecie().getNomeEspecie(),
                petCadastrado.getRaca().getIdRaca(),
                petCadastrado.getRaca().getNomeRaca(),
                petCadastrado.getCliente().getIdCliente(),
                petCadastrado.getCliente().getNomeC()
        );
    }

    public respostaPetDTO editarPet(Long id, requisicaoPetDTO dadosPet) {
        Optional<Pet> petEditarOptional = petRepository.findById(id);

        if (petEditarOptional.isEmpty()) {
            throw new RuntimeException("Dados do pet não encontrado");
        }

        Optional<Cliente> tutor = clienteRepository.findById(dadosPet.getClienteId());
        if (tutor.isEmpty()) {
            throw new RuntimeException("Tutor não encontrado");
        }

        Optional<Especie> especiePet = especieRepository.findById(dadosPet.getEspecieId());
        if (especiePet.isEmpty()) {
            throw new RuntimeException("Espécie não encontrada");
        }

        Optional<Raca> racaPet = racaRepository.findById(dadosPet.getRacaId());
        if (racaPet.isEmpty()) {
            throw new RuntimeException("Raça não encontrada");
        }

        Pet petEditar = petEditarOptional.get();

        petEditar.setNomePet(dadosPet.getNome());
        petEditar.setSexoPet(dadosPet.getSexo());
        petEditar.setDataNascPet(dadosPet.getDataNascimento());
        petEditar.setEspecie(especiePet.get());
        petEditar.setRaca(racaPet.get());
        petEditar.setCliente(tutor.get());

        Pet petEditado = petRepository.save(petEditar);

        return new respostaPetDTO (
                petEditado.getIdPet(),
                petEditado.getNomePet(),
                petEditado.getSexoPet(),
                petEditado.getDataNascPet(),
                petEditado.getEspecie().getIdEspecie(),
                petEditado.getEspecie().getNomeEspecie(),
                petEditado.getRaca().getIdRaca(),
                petEditado.getRaca().getNomeRaca(),
                petEditado.getCliente().getIdCliente(),
                petEditado.getCliente().getNomeC()
        );
    }

    public respostaPetDTO listarPet(Long id) {
        Optional<Pet> petOptional =petRepository.findById(id);

        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();

            return new respostaPetDTO (
                    pet.getIdPet(),
                    pet.getNomePet(),
                    pet.getSexoPet(),
                    pet.getDataNascPet(),
                    pet.getEspecie().getIdEspecie(),
                    pet.getEspecie().getNomeEspecie(),
                    pet.getRaca().getIdRaca(),
                    pet.getRaca().getNomeRaca(),
                    pet.getCliente().getIdCliente(),
                    pet.getCliente().getNomeC()
            );
        }
        return null;
    }

    public List<respostaPetDTO> listarPets() {
        List<respostaPetDTO> listaDadosPets = new ArrayList<>();

        List<Pet> listaPets = petRepository.findAll();

        for (Pet pet : listaPets) {
            listaDadosPets.add( new respostaPetDTO (
                    pet.getIdPet(),
                    pet.getNomePet(),
                    pet.getSexoPet(),
                    pet.getDataNascPet(),
                    pet.getEspecie().getIdEspecie(),
                    pet.getEspecie().getNomeEspecie(),
                    pet.getRaca().getIdRaca(),
                    pet.getRaca().getNomeRaca(),
                    pet.getCliente().getIdCliente(),
                    pet.getCliente().getNomeC()
            ));
        }
        return listaDadosPets;
    }

    public List<respostaPetDTO> findByTutorId(Long idCliente) {
        List<Pet> listaPets = petRepository.findByClienteIdCliente(idCliente);

        List<respostaPetDTO> listaDadosPets = new ArrayList<>();

        for (Pet pet : listaPets) {
            listaDadosPets.add( new respostaPetDTO (
                    pet.getIdPet(),
                    pet.getNomePet(),
                    pet.getSexoPet(),
                    pet.getDataNascPet(),
                    pet.getEspecie().getIdEspecie(),
                    pet.getEspecie().getNomeEspecie(),
                    pet.getRaca().getIdRaca(),
                    pet.getRaca().getNomeRaca(),
                    pet.getCliente().getIdCliente(),
                    pet.getCliente().getNomeC()
            ));
        }
        return listaDadosPets;
    }



}
