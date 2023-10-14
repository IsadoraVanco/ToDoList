package br.com.isadora.todolist.controller;

// import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

/*
* Controller é a primeira camada de acesso, fica entre a 
* requisição e as demais camadas(banco de dados, negócio, entre outros).
* Este package precisa estar dentro da todolist, para que o Spring a encontre
*/

//Permite maior flexibilidade ao utilizar o REST
// @Controller => incluso no RestController

//Responsável por tornar possível a criação da API, utiliza o REST
//Representa uma rota, path do browser
@RestController
//Define a rota para entrar na Controller. Ex: http://localhost:8080/primeiraRota/
@RequestMapping("/primeiraRota")
public class PrimeiraController {
    
    /*
     * No REST, vamos utilizar métodos de requisição HTTP:
     * GET - Busca uma informação
     * POST - Adiciona um dado/informação
     * DELETE - Remove um dado
     * PUT - Altera vários dados
     * PATCH - Altera um único dado
     */

    //Define o método HTTP que vai ser utilizado
    @GetMapping("/")
    public String primeiraMensagem(){
        return "Olá Teste :)";
    }
}
