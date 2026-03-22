# Order Management API

API REST para gerenciamento de pedidos, desenvolvida com Java e Quarkus.

## Objetivo

Disponibilizar operacoes de criacao e consulta de pedidos com validacao de entrada, persistencia relacional e documentacao OpenAPI.

## Tecnologias

- Java 21
- Quarkus 3.32.4
- Jakarta REST
- Hibernate ORM com Panache
- Hibernate Validator (Bean Validation)
- H2 (banco em memoria)
- SmallRye OpenAPI (Swagger UI)
- Maven

## Estrutura do Projeto

`src/main/java/com/luqtta`

- `controller`: endpoints HTTP
- `service`: regras de negocio
- `entity`: entidades JPA
- `dto`: contratos de entrada
- `domain`: enums e tipos de dominio
- `exception`: excecoes e mapeamento de erro

## Requisitos

- JDK 21
- Maven (ou Maven Wrapper do projeto)

## Execucao

### Modo de desenvolvimento

Linux/macOS:

```bash
./mvnw quarkus:dev
```

Windows:

```bat
mvnw.cmd quarkus:dev
```

Aplicacao: `http://localhost:8080`

## Documentacao da API

- Swagger UI: `http://localhost:8080/q/swagger-ui`
- OpenAPI: `http://localhost:8080/openapi`

## Endpoints

### Criar pedido

`POST /orders`

Exemplo de request:

```json
{
  "customerName": "Lucas Morais",
  "customerEmail": "lucas@email.com",
  "items": [
    {
      "productName": "Mouse Gamer",
      "quantity": 2,
      "unitPrice": 150.00
    },
    {
      "productName": "Teclado Mecanico",
      "quantity": 1,
      "unitPrice": 320.00
    }
  ]
}
```

Resposta esperada: `201 Created`

### Buscar pedido por ID

`GET /orders/{id}`

Resposta esperada:

- `200 OK` quando encontrado
- `404 Not Found` quando nao encontrado

### Listar pedidos com paginacao

`GET /orders?page=0&size=10`

Resposta esperada: `200 OK`

## Regras de Negocio

- Status inicial do pedido: `CREATED`
- `createdAt` definido na criacao do pedido
- `totalAmount` calculado automaticamente com base nos itens
- Cada pedido deve conter ao menos um item
- Campos de cliente e itens sao validados via Bean Validation

## Banco de Dados

Configuracao atual (desenvolvimento):

- Banco: H2 em memoria
- URL: `jdbc:h2:mem:orderdb`
- Usuario: `sa`
- Schema strategy: `drop-and-create`

Observacao: os dados sao perdidos ao reiniciar a aplicacao.

## Tratamento de Erros

Quando um pedido nao e encontrado, a API retorna `404 Not Found` com payload JSON.

Exemplo:

```json
{
  "timestamp": "2026-03-19T02:49:24.352075",
  "status": 404,
  "error": "Not Found",
  "message": "Order with id 111 not found"
}
```

## Build e Testes

Executar testes:

```bash
./mvnw test
```

Gerar pacote JVM:

```bash
./mvnw package
```

Gerar build nativo:

```bash
./mvnw package -Dnative
```

