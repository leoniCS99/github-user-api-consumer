# GitHub User API Consumer

Este projeto é uma aplicação de consumo de API que busca informações de usuários no GitHub.

## Design e compromissos

Para a criação desta aplicação, foram feitas as seguintes escolhas de design:

- Uso do Spring Boot como framework para facilitar o desenvolvimento e configuração da aplicação.
- Uso do Swagger para documentar e testar a API.
- Utilização do PostgreSQL como banco de dados para armazenar as informações dos usuários.
- Utilização do Openfeign do Spring para fazer requisições à API do GitHub.

## Como rodar a aplicação

Para rodar a aplicação, siga os seguintes passos:

1. Clone o repositório para o seu computador: `git clone https://github.com/seu-usuario/github-user-api-consumer.git`
2. Entre na pasta do projeto: `cd github-user-api-consumer`
3. Compile o projeto: `mvn clean install`
4. Rode a aplicação: `java -jar target/github-user-api-consumer-0.0.1-SNAPSHOT.jar`

A aplicação estará disponível em `http://localhost:8080`.

## Como testar a API

A API pode ser testada utilizando o Swagger. Para acessá-lo, basta abrir o seguinte endereço no navegador: `http://localhost:8080/swagger-ui.html`.

## Tecnologias utilizadas

- Spring Boot
- PostgreSQL
- Swagger
- Openfeign
