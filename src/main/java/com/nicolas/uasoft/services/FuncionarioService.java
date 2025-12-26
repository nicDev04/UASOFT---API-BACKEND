package com.nicolas.uasoft.services;

import com.nicolas.uasoft_refatoracao.DAO.FuncionarioDAO;
import com.nicolas.uasoft_refatoracao.classes.Funcionario;
import com.nicolas.uasoft_refatoracao.classes.Login;
import com.nicolas.uasoft_refatoracao.dtos.requisicao.requisicaoFuncionarioDTO;

public class FuncionarioService {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioService(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }
    
    private void salvarFuncionario(requisicaoFuncionarioDTO dadosFuncionario) {
        
        Login login = new Login(dadosFuncionario.getUsuario(), dadosFuncionario.getSenha());
        
        Funcionario funcionario = new Funcionario(
                dadosFuncionario.getNome(),
                dadosFuncionario.getCpf(),
                dadosFuncionario.getCpf(),
                dadosFuncionario.getEndereco(),
                dadosFuncionario.getTelefone(),
                dadosFuncionario.getCargo()
        );
        
        login.setFuncionario(funcionario);
        funcionario.setLogin(login); 
        
        funcionarioDAO.cadastrarFuncionario(funcionario);
    }
    
    public void listarFuncionario(Long id) {
        Funcionario funcionario = funcionarioDAO.listarFuncionario(id);
        
        System.out.println("--- Funcionario ---");
        System.out.println(funcionario.getNomeF() + "" + funcionario.getCargoF());
    }
}
