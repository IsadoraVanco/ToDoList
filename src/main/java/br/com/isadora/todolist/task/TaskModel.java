package br.com.isadora.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/*
 * Representa tudo o que envolve com as tarefas 
 * da aplicação. 
 */
@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id; //Id da tarefa
    private String description; //Descrição da tarefa
    private String priority; //Prioridade de uma tarefa
    //Formato: yyyy-mm-ddThh:mm:ss
    private LocalDateTime startAt; //Quando começa
    private LocalDateTime endAt; //Quando termina
    
    @Column(length = 50) //Limita o título em 50 caracteres
    private String title; //Título da tarefa
    
    private UUID idUser; //Id do Usuário
    
    @CreationTimestamp
    private LocalDateTime createdAt; //Quando foi criada

    //um setTitle customizado
    public void setTitle(String title) throws Exception{
        if(title.length() > 50){
            throw new Exception("O título deve conter no máximo 50 caracteres");

        }
        this.title = title;
    }   
}
