# Security Vault 🛡️

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/technologies/downloads/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Gerenciador de credenciais seguro construído com foco em **Clean Architecture** e princípios de segurança moderna.

---

## 🚀 Sobre o Projeto
O `Security Vault` é uma API RESTful de alta segurança projetada para o gerenciamento centralizado de credenciais sensíveis. O foco principal deste projeto é a **segurança na camada de dados** e a **manutenibilidade do código**. 

Desenvolvido sob o paradigma de **Clean Architecture**, o projeto promove uma separação clara entre as regras de negócio e os detalhes de infraestrutura. Isso garante que o núcleo do sistema seja agnóstico a tecnologias externas, facilitando a implementação de novos recursos, testes robustos e a adoção de práticas modernas de criptografia (AES-256) para proteger informações críticas em repouso.

---

## 🧩 Por que Clean Architecture?
A separação de responsabilidades é definida da seguinte forma:

* **Domain (O Coração):** Contém as entidades e regras de negócio puras. Esta camada não possui dependências externas, tornando a lógica de negócio imutável e independente de frameworks.
* **UseCase (A Orquestração):** Define os casos de uso da aplicação (como "Salvar Credencial"). Esta camada orquestra o fluxo de dados entre o *Domain* e a *Infrastructure*.
* **Infrastructure (Os Detalhes):** Aqui residem as implementações técnicas, como a persistência JPA com PostgreSQL, a configuração do Spring Security e a exposição dos endpoints (Controllers).



---

## 🎯 Funcionalidades Atuais
- [x] API RESTful para gerenciamento de credenciais.
- [x] Criptografia de dados sensíveis (AES 256).
- [x] Validação de dados de entrada com `@Valid`.
- [x] Documentação interativa via **Swagger UI**.
- [x] Suíte de Testes de Integração automatizada.

---

## ⚙️ Como Rodar

### Pré-requisitos
* Java 21 instalado.
* Docker instalado e rodando.

### Execução
1. **Suba o banco de dados e execute a aplicação:**
   ```bash
   docker-compose up -d
   ./mvnw.cmd spring-boot:run
2. **Após iniciar, acesse http://localhost:8080/swagger-ui.html para testar os endpoints.**
3. **Para garantir a integridade do sistema, utilize a suíte de testes de integração:**
   ./mvnw.cmd test

## 🛠️ Tecnologias Utilizadas
* **Java 21**
* **Spring Boot 3.2.5**
* **PostgreSQL & Docker**
* **SpringDoc OpenAPI** (Swagger)
* **JUnit 5 & MockMvc** (Testes de Integração)
---


