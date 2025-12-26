
package com.nicolas.uasoft.services;

import com.nicolas.uasoft_refatoracao.DAO.LoginDAO;
import com.nicolas.uasoft_refatoracao.classes.Login;
import com.nicolas.uasoft_refatoracao.utilidades.Criptografia;
import com.nicolas.uasoft_refatoracao.dtos.requisicao.requisicaoLoginDTO;

public class LoginService {
    
    private LoginDAO loginDAO;

    public LoginService(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
    
    public void login(requisicaoLoginDTO login) {
        String senha = Criptografia.toMD5(login.getSenha());
        Login usuario = loginDAO.usuario(login.getUsuario(), senha);
    }
}
