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
* Filtro para verificar se o usuário e senha estão corretos

## Aula 04 

* Modificando para que a autenticação de usuário e senha seja feita apenas pela url de tarefas: http://localhost:8080/tasks/
* Retira a inserção manual do Id do usuário na criação de uma tarefa
* Validação das horas
* Lista as tarefas de um usuário
    - Testando com o método GET pela url http://localhost:8080/tasks/ em uma auth
* Fazendo update de uma task (parcial)
    - Testando com o método PUT pela url http://localhost:8080/tasks/{idTask}
    - Copia as informações não nulas do objeto e a nova alteração para a tarefa

## Aula 05

* Validando usuário dono da tarefa
* Modifica a mensagem de erro para quando o título é grande demais
* Fazendo deploy da aplicação:
    - Utilizando o (Render)[https://render.com/]: para colocar o programa no ar e fazer deploy
    - Arquivo Docker para criar o arquivo de build no Render