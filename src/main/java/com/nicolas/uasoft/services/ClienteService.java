package com.nicolas.uasoft.services;

import com.nicolas.uasoft_refatoracao.DAO.ClienteDAO;
import com.nicolas.uasoft_refatoracao.classes.Cliente;
import com.nicolas.uasoft_refatoracao.dtos.requisicao.requisicaoClienteDTO;

public class ClienteService {
    
    private ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    public void salvarCliente(requisicaoClienteDTO dadosCliente) {
        Cliente cliente = new Cliente(
                dadosCliente.getNome(),
                dadosCliente.getCpf(),
                dadosCliente.getSexo(),
                dadosCliente.getTelefone(),
                dadosCliente.getEndereco()
        );
        
        clienteDAO.cadastrarCliente(cliente);
    }
}
