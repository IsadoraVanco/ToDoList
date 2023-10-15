package br.com.isadora.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Uma controller para as tarefas. Semelhante ao do
 * usuário. Controla as informações que vem e vão por meio das
 * URLs e requisições.
 */
@RestController
@RequestMapping("/tasks") //http://localhost:8080/tasks/
public class TaskController {

    @Autowired //O Spring irá gerenciar 
    private ITaskRepository taskRepository;

    @PostMapping("/") //Depois do /, lê a tarefa
    //O objeto taskModel da classe TaskModel será recebido pelo Body do Request
    public TaskModel create(@RequestBody TaskModel taskModel){

        System.out.println("A task passou pela controller!");
        //Salva a tarefa no banco
        var task = this.taskRepository.save(taskModel);
        return task;
    }
    
}
