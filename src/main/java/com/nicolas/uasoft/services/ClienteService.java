package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.Cliente;
import com.nicolas.uasoft.dtos.requisicao.requisicaoClienteDTO;
import com.nicolas.uasoft.dtos.resposta.respostaClienteDTO;
import com.nicolas.uasoft.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

        Cliente clienteSalvo = clienteRepository.save(cliente);

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

    public List<respostaClienteDTO> buscarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<respostaClienteDTO> responseClientes = new ArrayList<>();

        if (clientes.isEmpty()) {
            throw new RuntimeException("Clientes não encontrados");
        } else {
            for (Cliente cliente : clientes) {
                respostaClienteDTO clienteResponse = new respostaClienteDTO(
                        cliente.getIdCliente(),
                        cliente.getNomeC(),
                        cliente.getCpfC(),
                        cliente.getSexoC(),
                        cliente.getEnderecoC(),
                        cliente.getTelefoneC()
                );
                responseClientes.add(clienteResponse);
            }
            return responseClientes;
        }
    }

    public respostaClienteDTO editarDadosCliente(Long id, requisicaoClienteDTO dadoscliente) {
        Optional<Cliente> clienteEditar = clienteRepository.findById(id);

        if (clienteEditar.isEmpty()) {
            throw new RuntimeException("Erro ao tentar editar dados do cliente");
        } else {
            Cliente cliente = clienteEditar.get();

            cliente.setNomeC(dadoscliente.getNome());
            cliente.setCpfC(dadoscliente.getCpf());
            cliente.setTelefoneC(dadoscliente.getTelefone());
            cliente.setSexoC(dadoscliente.getSexo());

            Cliente clienteEditado = clienteRepository.save(cliente);

            return new respostaClienteDTO(
                    clienteEditado.getIdCliente(),
                    clienteEditado.getNomeC(),
                    clienteEditado.getCpfC(),
                    clienteEditado.getSexoC(),
                    clienteEditado.getEnderecoC(),
                    clienteEditado.getTelefoneC()
            );
        }
    }

}
