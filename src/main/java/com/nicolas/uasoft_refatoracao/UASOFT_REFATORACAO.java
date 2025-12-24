package com.nicolas.uasoft_refatoracao;

import com.nicolas.uasoft_refatoracao.DAO.ClienteDAO;
import com.nicolas.uasoft_refatoracao.DAO.EspecieDAO;
import com.nicolas.uasoft_refatoracao.DAO.FuncionarioDAO;
import com.nicolas.uasoft_refatoracao.dtos.requisicao.requisicaoClienteDTO;
import com.nicolas.uasoft_refatoracao.services.ClienteService;
import com.nicolas.uasoft_refatoracao.services.EspecieService;
import com.nicolas.uasoft_refatoracao.services.FuncionarioService;

public class UASOFT_REFATORACAO {

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteService clienteService = new ClienteService(clienteDAO);
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        FuncionarioService funcionarioService = new FuncionarioService(funcionarioDAO);
        
        EspecieDAO especieDAO = new EspecieDAO();
        EspecieService especieService = new EspecieService(especieDAO);
        
        //requisicaoClienteDTO dadosCLiente = new requisicaoClienteDTO("Nicolas", "12331341444", "masculino", "rua 000", "38941424242");
        //clienteService.salvarCliente(dadosCLiente);
        
        funcionarioService.listarFuncionario(Long.parseLong("1"));
        
        especieService.listarEspecies();
    }
}
