# Security Vault 🛡️

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/technologies/downloads/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Gerenciador de credenciais seguro construído com foco em **Clean Architecture** e princípios de segurança moderna.

---

## 🚀 Sobre o Projeto
O `Security Vault` é uma API RESTful desenvolvida para resolver o problema de armazenamento centralizado de credenciais. Diferente de soluções simples, este projeto isola a lógica de negócio da infraestrutura, garantindo que as regras de segurança sejam imutáveis, testáveis e independentes de frameworks externos.

## 🏗 Arquitetura
O projeto segue estritamente a separação de camadas:
* **Domain**: Regras de negócio puras e interfaces de gateway.
* **UseCase**: Implementação das regras de aplicação (lógica de salvar e listar).
* **Infrastructure**: Detalhes técnicos (API, banco de dados JPA, serviços de segurança).



## 🛠 Tecnologias Utilizadas
* **Java 21**
* **Spring Boot 3.2.5**
* **PostgreSQL** (via Docker)
* **Segurança:** Criptografia AES-128 para proteção de dados sensíveis

---

## ⚙️ Como Rodar

### Pré-requisitos
* Java 21 instalado.
* Docker instalado e rodando.

### Passos
1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/gabrielfguimar/spring-security-vault.git](https://github.com/gabrielfguimar/spring-security-vault.git)

⚙️ Como Rodar
Pré-requisitos
Java 21 instalado.

Docker instalado e rodando.
