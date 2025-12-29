⚙️ UASOFT-API (Back-End)

Este é o núcleo do sistema UASOFT, uma API REST robusta desenvolvida para gerenciar as operações de uma clínica veterinária. O projeto foi construído utilizando Java 17 e o ecossistema Spring Boot, garantindo escalabilidade, segurança e uma estrutura organizada em camadas.

🛠️ Tecnologias e Frameworks

    Java 17: Utilizando as últimas funcionalidades da linguagem (LTS).

    Spring Boot: Base do projeto.

    Spring Data JPA: Para persistência de dados e mapeamento objeto-relacional (ORM).

    MySQL: Banco de dados relacional para armazenamento persistente.

    Maven: Gerenciador de dependências e automação de build.
🏗️ Arquitetura do Projeto

O sistema segue o padrão de arquitetura em camadas para facilitar a manutenção e testes:

    Controller: Exposição dos endpoints REST e tratamento de requisições HTTP.

    Service: Concentra a lógica de negócio e regras de validação.

    Repository: Interface de comunicação direta com o banco de dados via JPA.

    Entity/DTO: Modelagem de dados e objetos de transferência para segurança da API.

🚀 Funcionalidades da API

A API fornece endpoints para:

    Gestão de Usuários: Autenticação e controle de cargos (Veterinário, Admin, Atendente).

    Módulo Clínico: Registro de consultas vinculando Pets, Tutores e Médicos Veterinários.

    Módulo Comercial: Venda e controle de produtos 

    Endpoints para Pets, Clientes, Funcionários e Produtos.

    Relacionamentos Dinâmicos: Filtros específicos, como busca de pets por ID de tutor.

📋 Pré-requisitos

    JDK 17 instalado.
    Maven 3.8+.
    MySQL Server rodando localmente ou em container.

🔧 Configuração e Execução

    Clone o repositório:
    git clone https://github.com/seu-usuario/uasoft-api.git

Configure o Banco de Dados: Edite o arquivo src/main/resources/application.properties com suas credenciais do MySQL:
Properties

Execute a aplicação:

    mvn spring-boot:run

A API estará disponível em http://localhost:8080, certifique de o fronte-end estar rodando em http://localhost:5500 ou altere o CORS Config para permitir requisições da porta desejada