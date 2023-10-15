package br.com.isadora.todolist.task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

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
    public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        //Modifica a instância de task, o atributo idUser com o Id do usuário autenticado
        taskModel.setIdUser((UUID) idUser);

        System.out.println("A task passou pela controller!");
        System.out.printf("Usuário %s logado %n", request.getAttribute("idUser"));
        //Salva a tarefa no banco
        var task = this.taskRepository.save(taskModel);
        return task;
    }
    
}
