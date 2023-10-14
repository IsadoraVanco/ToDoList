package br.com.isadora.todolist.user;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Interface é um "contrato", apenas com as declarações
 * das classes, sem suas implementações. São como os
 * headers utilizados no C.
 * 
 * <> significa que é um generator
 * 
 * extends significa que tudo que está na classe JPA 
 * estará também na IUserRepository
 */
//Utiliza do JPA para as classes de Repositório (Manipulação das tabelas) do User
//O Repositório representa a classe UserModel que possui id do tipo UUID
public interface IUserRepository extends JpaRepository<UserModel, UUID>{
    
}
