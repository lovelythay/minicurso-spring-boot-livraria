# Livraria API

API REST de uma livraria, desenvolvida com Spring Boot. A aplicação permite cadastrar e consultar livros e registrar vendas, atualizando o estoque dos livros vendidos.

## Tecnologias

- Java 21
- Spring Boot 4.1.2
- Spring Web MVC
- Spring Data JPA
- Bean Validation
- PostgreSQL
- Maven e Maven Wrapper
- Lombok

## Requisitos

- JDK 21
- PostgreSQL

## Configuração e execução

1. Crie um banco PostgreSQL. O nome configurado atualmente é `minicurso-spring-boot`.
2. Confira e ajuste a URL, o usuário e a senha do banco em `src/main/resources/application.yaml`. Não compartilhe credenciais reais em arquivos públicos.
3. Na raiz do projeto, execute:

   **Windows (PowerShell):**

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

   **Linux/macOS:**

   ```bash
   ./mvnw spring-boot:run
   ```

A API fica disponível em `http://localhost:8080`. O Hibernate está configurado para atualizar o esquema do banco (`ddl-auto: update`).

## Endpoints

Todos os endpoints estão sob o prefixo `/api/v1`.

### Livros

| Método | Endpoint | Descrição | Resposta |
|---|---|---|---|
| `GET` | `/api/v1/livro` | Lista os livros cadastrados. | `200 OK` |
| `GET` | `/api/v1/livro/{id}` | Busca um livro pelo ID. | `200 OK` ou `404 Not Found` |
| `POST` | `/api/v1/livro` | Cadastra um livro. | `201 Created` |
| `PUT` | `/api/v1/livro/{id}` | Atualiza os dados de um livro. | `200 OK` ou `404 Not Found` |
| `DELETE` | `/api/v1/livro/{id}` | Remove um livro. | `204 No Content` ou `404 Not Found` |

O corpo de cadastro e atualização usa `LivroRequestDTO`:

```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "quantidade": 10,
  "preco": 89.90
}
```

Título e autor são obrigatórios. O título deve ter entre 3 e 50 caracteres, o autor entre 3 e 30, e quantidade e preço devem ser informados com valores não negativos. A resposta inclui o `id` do livro, além dos campos enviados.

### Vendas

| Método | Endpoint | Descrição | Resposta |
|---|---|---|---|
| `GET` | `/api/v1/venda` | Lista as vendas registradas. | `200 OK` |
| `POST` | `/api/v1/venda` | Registra uma venda e reduz o estoque dos livros. | `200 OK` ou `400 Bad Request` |

Exemplo de corpo para registrar uma venda:

```json
{
  "data": "2026-11-08",
  "itens": [
    {
      "idLivro": 1,
      "precoUnitario": 89.90,
      "quantidade": 2
    }
  ]
}
```

A venda só é registrada se todos os livros informados existirem e houver estoque suficiente para as quantidades solicitadas. Em caso de sucesso, a resposta contém o ID, a data, o total e os itens da venda. Se algum livro não existir ou não houver estoque suficiente, a API retorna `400 Bad Request`.

## Estrutura do projeto

Os arquivos Java estão no pacote `br.edu.ifsp.pep.exercicioLivraria`:

```text
src/
├── main/
│   ├── java/br/edu/ifsp/pep/exercicioLivraria/
│   │   ├── ExercicioLivrariaApplication.java
│   │   ├── controller/   # Endpoints REST de livros e vendas
│   │   ├── dto/          # DTOs de requisição, resposta e itens de venda
│   │   ├── model/        # Entidades Livro, Venda e ItemVenda
│   │   ├── repository/   # Repositórios Spring Data JPA
│   │   └── service/      # Regras de negócio
│   └── resources/
│       └── application.yaml
└── test/
    └── java/br/edu/ifsp/pep/exercicioLivraria/
        └── ExercicioLivrariaApplicationTests.java
```

## Testes

Para executar os testes:

```powershell
.\mvnw.cmd test
```

No Linux/macOS, use `./mvnw test`.
