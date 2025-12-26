package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.Cliente;
import com.nicolas.uasoft.dtos.requisicao.requisicaoClienteDTO;
import com.nicolas.uasoft.dtos.resposta.respostaClienteDTO;
import com.nicolas.uasoft.repository.ClienteRepository;

import java.util.Optional;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public respostaClienteDTO salvarCliente(requisicaoClienteDTO dadosCliente) {
        Cliente cliente = new Cliente(
                dadosCliente.getNome(),
                dadosCliente.getCpf(),
                dadosCliente.getSexo(),
                dadosCliente.getTelefone(),
                dadosCliente.getEndereco()
        );

        Cliente clienteSalvo =  clienteRepository.save(cliente);

        return new respostaClienteDTO(
                clienteSalvo.getIdCliente(),
                clienteSalvo.getNomeC(),
                clienteSalvo.getCpfC(),
                clienteSalvo.getSexoC(),
                clienteSalvo.getEnderecoC(),
                clienteSalvo.getTelefoneC()
        );
    }

    public respostaClienteDTO buscarCliente(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()) {
            respostaClienteDTO dadosCliente = new respostaClienteDTO(
                    clienteOptional.get().getIdCliente(),
                    clienteOptional.get().getNomeC(),
                    clienteOptional.get().getCpfC(),
                    clienteOptional.get().getSexoC(),
                    clienteOptional.get().getEnderecoC(),
                    clienteOptional.get().getTelefoneC()
            );

            return dadosCliente;
        }
        return null;
    }
}
