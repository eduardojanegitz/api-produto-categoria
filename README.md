# API RESTful - Serviço de Produtos e Categorias

Este é o repositório da API RESTful que implementa o design pattern Service Repository para gerenciar produtos e categorias. Esta API foi desenvolvida utilizando o framework Spring Boot, proporcionando uma arquitetura robusta e eficiente.

## Estrutura do Projeto

O projeto segue a organização de Service Repository, dividindo as responsabilidades entre serviços e repositórios para garantir uma arquitetura modular e de fácil manutenção.

- **`/src`**: Contém o código-fonte da aplicação.
  - **`/src/main/java/com/example/ac2/services`**: Classes responsáveis pela lógica de negócios.
  - **`/src/main/java/com/example/ac2/repositories`**: Implementações dos repositórios para acesso a dados.
  - **`/src/main/java/com/example/ac2/controllers`**: Controladores que lidam com as requisições HTTP.
  - **`/src/main/java/com/example/ac2/models`**: Definição dos modelos de dados para produtos e categorias.
  - **`/src/main/java/com/example/ac2/dtos`**: Responsável por fazer a transferência de dados.

## Endpoints
 - http://localhost:8080
 - 
### Produtos

- **`GET /api/produto`**: Obtém a lista de todos os produtos.
- **`GET /api/produto/{id}`**: Obtém detalhes de um produto específico por ID.
- **`POST /api/produto`**: Cria um novo produto.
- **`PUT /api/produto/{id}`**: Atualiza um produto existente por ID.
- **`DELETE /api/produto/{id}`**: Exclui um produto por ID.

### Categorias

- **`GET /api/categoria`**: Obtém a lista de todas as categorias.
- **`GET /api/categoria/{id}`**: Obtém detalhes de uma categoria específica por ID.
- **`POST /api/categoria`**: Cria uma nova categoria.
- **`PUT /api/categoria/{id}`**: Atualiza uma categoria existente por ID.
- **`DELETE /api/categoria/{id}`**: Exclui uma categoria por ID.

## Requisitos

Certifique-se de ter as seguintes ferramentas instaladas antes de executar a aplicação:

- Java
- Spring Boot
- Banco de dados (H2)

## Configuração

1. Clone este repositório: `git clone https://github.com/eduardojanegitz/api-produto-categoria.git`
2. Navegue até o diretório do projeto: `cd api-produto-categoria`
3. Configure as informações do banco de dados no arquivo `application.properties`.

## Execução

Para iniciar a aplicação, execute o comando:

```bash
./mvnw spring-boot:run
