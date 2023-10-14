package br.com.isadora.todolist.user;

import java.util.UUID;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/*
 * Modelo com as informações dos usuários * 
 */
@Data //É responsável por criar todos os getters e setters da classe
@Entity(name="tb_users") //A classe será conhecida como a entidade (tabela) "tb_users"
public class UserModel {

    @Id //Define como chave primária
    @GeneratedValue(generator="UUID") //Gera um valor UUID para o elemento
    //Representa um código único para cada informação no formato UUID 
    private UUID id; 
    
    // @Column(name="usuario") //Define que o username será a coluna "usuario" da tabela
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt; //Representa quando o elemento foi criado
}
