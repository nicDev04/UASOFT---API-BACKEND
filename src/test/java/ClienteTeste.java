
import com.nicolas.uasoft_refatoracao.classes.Cliente;
import com.nicolas.uasoft_refatoracao.dtos.requisicao.requisicaoClienteDTO;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClienteTeste {

    @Test
    @DisplayName("Deve criar uma entidade Cliente corretamente a partir de um DTO de requisição")
    void deveCriarEntidadeAPartirDoDto() {
        requisicaoClienteDTO dto = new requisicaoClienteDTO(
                "Nicolas",
                "12345678900",
                "Masculino",
                "Rua 0000, 123",
                "38999999999"
        );

        // Aqui é simulado o que ocorre no service, com a entidade sendo criada
        Cliente cliente = new Cliente(
                dto.getNome(),
                dto.getCpf(),
                dto.getSexo(),
                dto.getTelefone(),
                dto.getEndereco()
        );
        cliente.setIdCliente(0);

        Assertions.assertAll("Verificando mapeamento de campos",
                () -> assertEquals(dto.getNome(), cliente.getNomeC(), "O nome deve ser mapeado para nomeC"),
                () -> assertEquals(dto.getCpf(), cliente.getCpfC(), "O CPF deve ser mapeado para cpfC"),
                () -> assertEquals(dto.getSexo(), cliente.getSexoC(), "O sexo deve ser mapeado para sexoC"),
                () -> assertEquals(dto.getTelefone(), cliente.getTelefoneC(), "O telefone deve ser mapeado para telefoneC"),
                () -> assertEquals(dto.getEndereco(), cliente.getEnderecoC(), "O endereço deve ser mapeado para enderecoC"),
                () -> assertEquals(0, cliente.getIdCliente(), "O ID deve ser zero ou nulo antes de ser persistido")
        );
    }

}
