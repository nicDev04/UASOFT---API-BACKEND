package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.Funcionario;
import com.nicolas.uasoft.dtos.requisicao.requisicaoLoginDTO;
import com.nicolas.uasoft.dtos.resposta.respostaLoginDTO;
import com.nicolas.uasoft.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final FuncionarioRepository funcionarioRepository;

    public LoginService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public respostaLoginDTO login(requisicaoLoginDTO loginDTO) {

        Funcionario funcionario = funcionarioRepository.findByLogin(loginDTO.getUsuario());

        if (funcionario == null) {
            return null;
        }

        boolean senhaCorreta = passwordEncoder.matches(
                loginDTO.getSenha(),
                funcionario.getLogin().getSenha()
        );

        if (!senhaCorreta) {
            return null;
        }

        return new respostaLoginDTO (
                funcionario.getIdFuncionario(),
                funcionario.getNomeF(),
                funcionario.getLogin().getLogin(),
                funcionario.getCargoF()
        );
    }
}
