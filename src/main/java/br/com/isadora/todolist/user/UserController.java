package br.com.isadora.todolist.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired //O Spring irá gerenciar o ciclo de vida do atributo
    private IUserRepository userRepository;
    
    /*
     * Cria um novo usuário através da requisição feita.
     * Será lida pelo método POST, que será lida pelo Body do HTML
     */
    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel){
        System.out.printf("Novo usuário: %s (%s) senha: %s%n", userModel.getName(), userModel.getUsername(), userModel.getPassword());
        
        var user = this.userRepository.findByUsername(userModel.getUsername()); //Verifica se o username já existe no banco

        if(user != null){ //O usuário já existe no banco
            System.out.printf("O usuário (%s) já existe %n", userModel.getUsername());
            return null;
        }

        var userCreated = this.userRepository.save(userModel); //Salva o usuário passado no BD e na variável
        return userCreated;
    }
}
