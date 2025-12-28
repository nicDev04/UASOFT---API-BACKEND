package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.*;
import com.nicolas.uasoft.dtos.requisicao.requisicaoConsultaDTO;
import com.nicolas.uasoft.dtos.resposta.respostaConsultaDTO;
import com.nicolas.uasoft.dtos.resposta.respostaVendaDTO;
import com.nicolas.uasoft.repository.ClienteRepository;
import com.nicolas.uasoft.repository.ConsultaRepository;
import com.nicolas.uasoft.repository.FuncionarioRepository;
import com.nicolas.uasoft.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    private final ClienteRepository clienteRepository;
    private final PetRepository petRepository;
    private final FuncionarioRepository funcionarioRepository;

    public ConsultaService(ConsultaRepository consultaRepository, ClienteRepository clienteRepository, PetRepository petRepository, FuncionarioRepository funcionarioRepository) {
        this.consultaRepository = consultaRepository;
        this.clienteRepository = clienteRepository;
        this.petRepository = petRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public respostaConsultaDTO salvarConsulta(requisicaoConsultaDTO dadosConsulta) {

        Optional<Cliente> clienteOptional = clienteRepository.findById(dadosConsulta.getIdCliente());
        if (clienteOptional.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        }

        Optional<Pet> petOptional = petRepository.findById(dadosConsulta.getIdPet());
        if (petOptional.isEmpty()) {
            throw new RuntimeException("Pet não encontrado");
        }

        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(dadosConsulta.getIdFuncionario());
        if (funcionarioOptional.isEmpty()) {
            throw new RuntimeException("Funcionário não encontrado");
        }

        Consulta consulta = new Consulta(
                clienteOptional.get(),
                petOptional.get(),
                funcionarioOptional.get(),
                LocalDate.now(),
                dadosConsulta.getValorConsulta(),
                dadosConsulta.getValorMedicamentos(),
                dadosConsulta.getObservacoes()
        );

        Consulta consultaSalva = consultaRepository.save(consulta);

        return new respostaConsultaDTO(
                consultaSalva.getIdConsulta(),
                consultaSalva.getCliente().getNomeC(),
                consultaSalva.getPet().getNomePet(),
                consultaSalva.getFuncionario().getNomeF(),
                consultaSalva.getDataConsulta(),
                consultaSalva.getValorConsulta(),
                consultaSalva.getValorMedicamentos(),
                consultaSalva.getObservacoes()
        );
    }

    public List<respostaConsultaDTO> buscarConsultas() {
        List<Consulta> consultas = consultaRepository.findAll();
        List<respostaConsultaDTO> dadosConsultas = new ArrayList<>();

        if (!consultas.isEmpty()) {
            for (Consulta consulta : consultas) {
                respostaConsultaDTO dadosConsulta = new respostaConsultaDTO(
                        consulta.getIdConsulta(),
                        consulta.getCliente().getNomeC(),
                        consulta.getPet().getNomePet(),
                        consulta.getFuncionario().getNomeF(),
                        consulta.getDataConsulta(),
                        consulta.getValorConsulta(),
                        consulta.getValorMedicamentos(),
                        consulta.getObservacoes()
                );
                dadosConsultas.add(dadosConsulta);
            }
        }
        return dadosConsultas;
    }
}
