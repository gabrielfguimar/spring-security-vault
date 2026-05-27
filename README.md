Security Vault 🛡️
Gerenciador de credenciais seguro construído com foco em Clean Architecture e princípios de segurança moderna.

🚀 Sobre o Projeto
O Security Vault é uma API RESTful desenvolvida para resolver o problema de armazenamento centralizado de credenciais. Diferente de soluções simples, este projeto isola a lógica de negócio da infraestrutura, garantindo que as regras de segurança sejam imutáveis e testáveis, independentemente do banco de dados ou framework utilizado.

🛠 Tecnologias Utilizadas
Java 21

Spring Boot 3.2.5

Arquitetura: Clean Architecture (Domínio, Casos de Uso e Infraestrutura)

Persistência: PostgreSQL (via Docker)

Segurança: Criptografia AES-128 para proteção de dados sensíveis

🏗 Estrutura da Arquitetura
O projeto segue estritamente a separação de camadas para garantir a desacoplagem:

domain: Contém as entidades e interfaces de gateway (regras de negócio puras).

usecase: Implementação das regras de aplicação (a lógica de "como" salvar e listar).

infrastructure: Implementação dos detalhes técnicos (API, banco de dados JPA, serviços de segurança).

⚙️ Como Rodar
Pré-requisitos
Java 21 instalado.

Docker instalado e rodando.
