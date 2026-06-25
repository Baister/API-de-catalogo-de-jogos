# 🎮 Catálogo de Jogos API

Uma API REST completa para gerenciamento de um catálogo de jogos, permitindo cadastrar, listar, atualizar e deletar jogos. Desenvolvida utilizando boas práticas com Spring Boot, arquitetura em camadas (Controller, Service, Repository) e uso de Records para DTOs.

---

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Maven** (Gerenciador de dependências e build)
* **Spring Boot**
* **Hibernate / Spring Data JPA** (Persistência e mapeamento objeto-relacional)
* **MySQL** (Banco de dados relacional)
* **Validation** (Validação de dados de entrada)
* **SpringDoc OpenApi / Swagger** (Documentação interativa da API)

---

## 🛠️ Recursos e Funcionalidades

* **Estrutura organizada em DTOs:** Utilização de `Java Records` para transferência segura de dados (`JogoRequest` e `JogoResponse`).
* **CRUD Completo de Jogos:**
    * Cadastro de novos títulos.
    * Listagem completa com tratamento de conteúdo vazio (`204 No Content`).
    * Busca detalhada por ID.
    * Atualização cadastral.
    * Exclusão de registros.
* **Documentação integrada:** Endpoints documentados através do Swagger UI.

---

## 📌 Endpoints da API

A API responde no caminho base `/api/jogos`.

| Método | Endpoint | Descrição | Status Sucesso |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/jogos` | Lista todos os jogos cadastrados | `200 OK` / `204 No Content` |
| **GET** | `/api/jogos/{id}` | Busca um jogo específico pelo ID | `200 OK` |
| **POST** | `/api/jogos` | Cadastra um novo jogo | `200 OK` |
| **PUT** | `/api/jogos/{id}` | Atualiza as informações de um jogo | `200 OK` |
| **DELETE** | `/api/jogos/{id}` | Remove um jogo do catálogo | `200 OK` |

### 📋 Exemplo de Payload (JSON)

**POST /api/jogos** (Enviar no corpo da requisição):
```json
{
  "titulo": "The Witcher 3: Wild Hunt",
  "desenvolvedora": "CD Projekt Red",
  "anoLancamento": 2015,
  "preco": 79.90
}
