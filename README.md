# Security Vault 🛡️

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/technologies/downloads/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Gerenciador de credenciais seguro construído com foco em **Clean Architecture** e princípios de segurança moderna.

---

## 🚀 Sobre o Projeto
O `Security Vault` é uma API RESTful de alta segurança projetada para o gerenciamento centralizado de credenciais sensíveis. O foco principal deste projeto é a **segurança na camada de dados**, a **auditoria de acessos** e a **manutenibilidade do código**. 

Desenvolvido sob o paradigma de **Clean Architecture**, o projeto promove uma separação clara entre as regras de negócio e os detalhes de infraestrutura. Isso garante que o núcleo do sistema seja agnóstico a tecnologias externas, facilitando a implementação de novos recursos, testes robustos e a adoção de práticas modernas de criptografia (AES-256).

---

## 🧩 Arquitetura e Segurança
O projeto adota padrões de engenharia para garantir robustez e rastreabilidade:

* **Clean Architecture:** Separação entre Domain (regras de negócio), UseCase (orquestração) e Infrastructure (detalhes técnicos).
* **Auditoria de Acesso:** Implementada via **Spring AOP (Aspect-Oriented Programming)**, permitindo registrar automaticamente todas as ações críticas do sistema sem poluir a lógica de negócio.
* **Segurança em Repouso:** Criptografia AES-256 para todas as credenciais armazenadas.

---

## 🎯 Funcionalidades Atuais
- [x] API RESTful para gerenciamento de credenciais.
- [x] Criptografia de dados sensíveis (AES 256).
- [x] **Auditoria de Acesso automatizada** (AOP).
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
* **Spring AOP (Auditoria)**
* **PostgreSQL & Docker**
* **SpringDoc OpenAPI** (Swagger)
* **JUnit 5 & MockMvc** (Testes de Integração)
---
