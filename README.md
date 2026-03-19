# API de Gerenciamento de Pedidos

Projeto backend fictício desenvolvido com **Java + Quarkus**, simulando uma API real de gerenciamento de pedidos utilizada em sistemas de e-commerce, delivery ou fintech.

Este projeto foi criado como peça de portfólio, demonstrando conceitos essenciais de desenvolvimento backend utilizados por empresas e bancos.

---

## 🚀 Tecnologias Utilizadas

* Java 21
* Quarkus
* REST API (Jakarta REST)
* Hibernate ORM com Panache
* Banco H2 (em memória)
* Bean Validation
* Swagger / OpenAPI
* Maven

---

## ✅ Funcionalidades

* Criação de pedidos com múltiplos itens
* Cálculo automático do valor total
* Controle de status com Enum
* Consulta de pedido por ID
* Listagem de pedidos com paginação
* Tratamento de erro 404 personalizado
* Validação de dados de entrada

---

## 📁 Estrutura do Projeto

```
src/main/java/com/luqtta/
├── controller
├── domain
├── dto
├── entity
├── exception
└── service
```

---

## ▶️ Como Executar o Projeto

### 1. Clonar o repositório

```
git clone <url-do-repositorio>
cd order-management-api
```

---

### 2. Executar em modo desenvolvimento

Linux / Mac:

```
./mvnw quarkus:dev
```

Windows:

```
mvnw.cmd quarkus:dev
```

---

### 3. Acessar a documentação da API (Swagger)

```
http://localhost:8080/q/swagger-ui
```

---

## 🗄️ Banco de Dados

O projeto utiliza **H2 em memória** apenas para desenvolvimento.

Importante:

* Os dados são perdidos ao reiniciar a aplicação
* O esquema do banco é recriado automaticamente ao iniciar

---

## 🔗 Endpoints da API

### ➕ Criar Pedido

**POST** `/orders`

Exemplo de requisição:

```
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
      "productName": "Teclado Mecânico",
      "quantity": 1,
      "unitPrice": 320.00
    }
  ]
}
```

Resposta: **201 Created**

---

### 🔍 Buscar Pedido por ID

**GET** `/orders/{id}`

Exemplo:

```
GET /orders/1
```

Respostas possíveis:

* 200 OK — Pedido encontrado
* 404 Not Found — Pedido não encontrado

---

### 📄 Listar Pedidos (Paginado)

**GET** `/orders?page=0&size=10`

Exemplo:

```
GET /orders?page=0&size=5
```

Resposta: **200 OK**

---

## ⚠️ Exemplo de Resposta de Erro

```
{
  "error": "Not Found",
  "message": "Order with id 111 not found",
  "timestamp": "2026-03-19T02:49:24.352075",
  "status": 404
}
```

---

## 🧠 Conceitos Demonstrados

* Desenvolvimento de API REST
* Modelagem de domínio
* Relacionamento One-to-Many (Pedido → Itens)
* Transações com JPA
* Validação de dados
* Tratamento global de exceções
* Paginação com Panache
* Controle de serialização JSON

---

## 🔮 Possíveis Melhorias Futuras

* Atualização de status do pedido
* Endpoint de cancelamento
* Simulação de pagamento
* DTOs de resposta
* Integração com PostgreSQL
* Dockerização
* Testes automatizados
* Autenticação e autorização

---

## 👨‍💻 Autor

Lucas Morais Souza
