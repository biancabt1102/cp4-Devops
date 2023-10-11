# Projeto de Cadastro de Clientes e Endereços - DimDim
 
Este é um projeto de cadastro de clientes e endereços desenvolvido para a empresa DimDim. Ele permite que a empresa gerencie os dados pessoais dos clientes, bem como os endereços cadastrados por eles.

## Funcionalidades

O projeto inclui as seguintes funcionalidades:

- Listagem de todos os clientes cadastrados.
- Cadastro de novos clientes com validação de dados.
- Edição dos dados de um cliente existente.
- Exclusão de um cliente.
- Listagem de endereços associados a cada cliente.
- Cadastro de novos endereços para um cliente.
- Edição dos dados de um endereço existente.
- Exclusão de um endereço.

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- Java
- Spring Boot
- Thymeleaf (para a camada de visualização)
- Oracle Database (configuração no arquivo `application.properties`)
- HTML/CSS (para as páginas web)
- Bootstrap (para o estilo das páginas)

## Configuração do Banco de Dados

Para configurar o banco de dados Microsoft SQLServer, edite o arquivo `application.properties` com as informações de conexão:

```
spring.datasource.url=url
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.hibernate.ddl-auto=update
```
<p style="color:red;font-size:20px;font-weight:600;">Dica!!</p>

Para colocar a url, logo após de criar o Banco de Dados na Azure e acessar o banco "dimdimdb" você vai em "Cadeia de conexão" seleciona a opção "JDBC" e copie o endereço que ele está dando. Após isso, cole o endereço na `spring.datasource.url`, altere também o `password` que está dentro da URL.

Certifique-se de substituir `username` e `password` pelas credenciais adequadas do seu banco de dados.

## Como Executar o Projeto

1. Clone este repositório para a sua máquina
2. Navegue até a pasta do projeto
3. Execute o projeto
4. Abra um navegador e acesse `http://localhost:8080` para usar a aplicação.

## Contribuição

Este projeto é de código aberto, e contribuições são bem-vindas. Sinta-se à vontade para enviar pull requests ou relatar problemas.

## Licença

Este projeto é licenciado sob a [Licença MIT](LICENSE).
