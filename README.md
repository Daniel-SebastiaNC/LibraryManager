# 📚 LibraryManager

Sistema de Gerenciamento de Bibliotecas desenvolvido para administração eficiente de livros e leitores.  
Permite controle completo de empréstimos e devoluções, com segurança de acesso via autenticação de administradores.

## ✨ Funcionalidades

- CRUD completo para gerenciamento de livros
- Cadastro e gerenciamento de leitores
- Controle de empréstimos e devoluções
- Sistema de autenticação para administradores
- Documentação interativa da API com Swagger OpenAPI

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Security
- Spring JPA
- Docker
- PostgreSQL
- Swagger OpenAPI
- FlywayDB
- Lombok

## 📄 Documentação da API

A documentação completa da API está disponível via Swagger:  
> Após rodar o projeto, acesse:  
> [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Imagem de exemplo da documentação:

![image](https://github.com/user-attachments/assets/e93e8f27-275c-465c-99f7-8d1dec6d73ea)


## 📌 Requisitos

- Java 17
- Maven 3.x
- Docker (opcional, para rodar banco de dados)
- PostgreSQL

## 📚 Scripts Flyway

As migrações do banco de dados são gerenciadas automaticamente pelo Flyway ao subir a aplicação.

## 📃 Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 🤝 Contribuindo

Contribuições são bem-vindas!  
Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFeature`)
3. Commit suas alterações (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/NovaFeature`)
5. Abra um Pull Request
