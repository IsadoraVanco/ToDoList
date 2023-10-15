# To Do List

Projeto criado durante o curso de Java da Rocketseat.

## O que foi utilizado?

* Maven: o gerenciador de dependências do Java
* Spring: Framework para facilitar a vida
    - Spring Boot DevTools
    - Spring Web
    - Lombok
    - Spring Data JPA
    - H2 Database
    - Bcrypt
* API DOG: Para fazer testes de requisição HTTP (entre outros)
* VSCode:
    - vscjava.vscode-java-pack
    - vscjava.vscode-spring-initializr
    - vmware.vscode-spring-boot
    - vscjava.vscode-spring-boot-dashboard

## Aula 01

* Instalação dos programas e frameworks
* Exemplo de Controller
* Criando uma classe para Controller e testando utilizando API DOG
    - Utilizando o método POST, manda um arquivo json (com atributos para o UserModel) pelo Body para a URL http://localhost:8080/users/

## Aula 02

* Getters e setters do UserModel
* Adiciona a lib Lombok como dependência do Spring para criar e gerenciar os getters e setters da classe UserModel
* Integrando o banco de dados H2 com o projeto e acessando pela URL http://localhost:8080/h2-console/
* Validando o username de cada usuário para não ser repetido
* Utilizando retornos diferentes (erros e sucessos) para cada requisição

## Aula 03

* Criptografando a senha no banco de dados
* Cria para as Tasks: uma classe de modelo, um controller e uma interface
* Filtro para verificar se existe o usuário e senha está correto