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

Para configurar o banco de dados Oracle, edite o arquivo `application.properties` com as informações de conexão:

```
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect
spring.jpa.hibernate.ddl-auto=update
```


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
