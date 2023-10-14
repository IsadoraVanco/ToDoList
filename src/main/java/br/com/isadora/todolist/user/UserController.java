package br.com.isadora.todolist.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Controller do usuário. Irá controlar as rotas 
 * requisitadas pelo client.
 */
@RestController
@RequestMapping("/users") //http://localhost:8080/users/
public class UserController {
    
    /*
     * Cria um novo usuário através da requisição feita.
     * Será lida pelo método POST
     */
    @PostMapping("/")
    public void create(@RequestBody UserModel userModel){
        System.out.printf("Novo usuário: %s (%s) senha: %s%n", userModel.name, userModel.username, userModel.password);
    }
}
