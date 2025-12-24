
import com.nicolas.uasoft_refatoracao.classes.Funcionario;
import com.nicolas.uasoft_refatoracao.classes.Login;
import com.nicolas.uasoft_refatoracao.dtos.requisicao.requisicaoFuncionarioDTO;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FuncionarioTeste {
    @Test
    @DisplayName("Deve criar Funcionario e Login corretamente a partir do DTO")
    void deveCriarFuncionarioELoginAPartirDoDto() {
        // Arrange
        requisicaoFuncionarioDTO dto = new requisicaoFuncionarioDTO(
            "Carlos Silva", "111.222.333-44", "M", 
            "Rua Central", "11988887777", "Gerente", 
            "carlos.admin", "senhaSegura123"
        );

        
        //Criar a entidade principal, que é o funcionário
        Funcionario funcionario = new Funcionario(
            dto.getNome(), dto.getCpf(), dto.getSexo(), 
            dto.getEndereco(), dto.getTelefone(), dto.getCargo()
        );

        //Criar o login para poder conectar ao funcionário
        Login login = new Login(dto.getUsuario(), dto.getSenha(), funcionario);
        
        //setando o login dentro do funcionario
        funcionario.setLogin(login);
       
        
         // Verificalções da criação da entidade
        Assertions.assertAll("Verificação de mapeamento do Funcionário",
            () -> assertEquals(dto.getNome(), funcionario.getNomeF()),
            () -> assertEquals(dto.getCargo(), funcionario.getCargoF()),
            () -> assertNotNull(funcionario.getLogin(), "O funcionário deve ter um objeto Login atrelado")
        );

        assertAll("Verificação de mapeamento do Login",
            () -> assertEquals(dto.getUsuario(), funcionario.getLogin().getLogin()),
            () -> assertEquals(dto.getSenha(), funcionario.getLogin().getSenha()),
            () -> assertEquals(funcionario, funcionario.getLogin().getFuncionario(), 
                  "O Login deve apontar de volta para o funcionário correto")
        );
    }
}
