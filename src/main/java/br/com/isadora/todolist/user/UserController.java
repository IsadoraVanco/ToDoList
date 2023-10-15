package br.com.isadora.todolist.user;

import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity create(@RequestBody UserModel userModel){
        
        var user = this.userRepository.findByUsername(userModel.getUsername()); //Verifica se o username já existe no banco
        
        if(user != null){ //O usuário já existe no banco
            System.out.printf("O usuário (%s) já existe %n", userModel.getUsername());
            
            //Status code (HTTP): BAD REQUEST = 400 
            //Mostra no body a mensagem de erro
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O Usuário já existe"); 
        }
        System.out.printf("Novo usuário: %s (%s) senha: %s%n", userModel.getName(), userModel.getUsername(), userModel.getPassword());
        
        //Criptografa a senha 
        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
        userModel.setPassword(passwordHashred); //Define a senha criptografada no usuário
        
        //Salva o usuário passado no BD e na variável
        var userCreated = this.userRepository.save(userModel); 
        
        //Status code (HTTP): CREATED = 201
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated); 
    }
}
