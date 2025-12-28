package com.nicolas.uasoft.services;

import com.nicolas.uasoft.classes.Funcionario;
import com.nicolas.uasoft.classes.Login;
import com.nicolas.uasoft.dtos.requisicao.requisicaoFuncionarioDTO;
import com.nicolas.uasoft.dtos.resposta.respostaFuncionarioDTO;
import com.nicolas.uasoft.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public respostaFuncionarioDTO salvarFuncionario(requisicaoFuncionarioDTO  dadosFuncionario) {
        String senhaHash = passwordEncoder.encode(dadosFuncionario.getSenha());
        Login login = new Login(dadosFuncionario.getUsuario(), senhaHash);

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

        Funcionario funcionarioSalvo  = funcionarioRepository.save(funcionario);

        return  new respostaFuncionarioDTO(
                funcionarioSalvo.getIdFuncionario(),
                funcionarioSalvo.getNomeF(),
                funcionarioSalvo.getCpfF(),
                funcionarioSalvo.getSexoF(),
                funcionarioSalvo.getEnderecoF(),
                funcionarioSalvo.getTelefoneF(),
                funcionarioSalvo.getCargoF(),
                funcionarioSalvo.getLogin().getLogin()
        );
    }

    public respostaFuncionarioDTO editarFuncionario(Long id, requisicaoFuncionarioDTO  dadosFuncionario) {
        Optional<Funcionario> funcionarioEditarOptional = funcionarioRepository.findById(id);

        if (funcionarioEditarOptional.isEmpty()) {
            throw new RuntimeException("Dados do funcionário não encontrado");
        }

        Funcionario funcionarioEditar = funcionarioEditarOptional.get();

        funcionarioEditar.setCargoF(dadosFuncionario.getCargo());
        funcionarioEditar.setCpfF(dadosFuncionario.getCpf());
        funcionarioEditar.setSexoF(dadosFuncionario.getSexo());
        funcionarioEditar.setEnderecoF(dadosFuncionario.getEndereco());

        funcionarioEditar.getLogin().setLogin(dadosFuncionario.getUsuario());

        String senhaHash = passwordEncoder.encode(dadosFuncionario.getSenha());
        funcionarioEditar.getLogin().setSenha(senhaHash);

        Funcionario funcionarioEditado  = funcionarioRepository.save(funcionarioEditar);

        return  new respostaFuncionarioDTO(
                funcionarioEditado.getIdFuncionario(),
                funcionarioEditado.getNomeF(),
                funcionarioEditado.getCpfF(),
                funcionarioEditado.getSexoF(),
                funcionarioEditado.getEnderecoF(),
                funcionarioEditado.getTelefoneF(),
                funcionarioEditado.getCargoF(),
                funcionarioEditado.getLogin().getLogin()
        );
    }

    public List<respostaFuncionarioDTO> listarFuncionarios() {
        List<respostaFuncionarioDTO> listaDadosFuncionarios = new ArrayList<>();

        List<Funcionario> listaFuncionarios = funcionarioRepository.findAll();

        for (Funcionario funcionario : listaFuncionarios) {
            listaDadosFuncionarios.add( new respostaFuncionarioDTO (
                    funcionario.getIdFuncionario(),
                    funcionario.getNomeF(),
                    funcionario.getCpfF(),
                    funcionario.getSexoF(),
                    funcionario.getEnderecoF(),
                    funcionario.getTelefoneF(),
                    funcionario.getCargoF(),
                    funcionario.getLogin().getLogin()
            ));
        }
        return listaDadosFuncionarios;
    }


    public respostaFuncionarioDTO listarFuncionario(Long id) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);

        if (funcionarioOptional.isPresent()) {
            Funcionario funcionario = funcionarioOptional.get();

            return  new respostaFuncionarioDTO(
                    funcionario.getIdFuncionario(),
                    funcionario.getNomeF(),
                    funcionario.getCpfF(),
                    funcionario.getSexoF(),
                    funcionario.getEnderecoF(),
                    funcionario.getTelefoneF(),
                    funcionario.getCargoF(),
                    funcionario.getLogin().getLogin()
            );
        }
        return null;
    }
}
