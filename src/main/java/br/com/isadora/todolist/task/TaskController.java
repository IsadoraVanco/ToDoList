package br.com.isadora.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        //Modifica a instância de task, o atributo idUser com o Id do usuário autenticado
        taskModel.setIdUser((UUID) idUser);

        System.out.println("A task passou pela controller!");
        System.out.printf("Usuário %s logado %n", request.getAttribute("idUser"));

        //Validação da data
        var currentDate = LocalDateTime.now();
        //Se a data inserida para o inicio ou de término da tarefa já passou
        if(currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())){ 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início/término não pode ser no passado");
        }

        //Se a data inserida para o inicio é depois da data de término
        if(taskModel.getStartAt().isAfter(taskModel.getEndAt())){ 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início deve ser antes da data de término");
        }

        //Salva a tarefa no banco
        var task = this.taskRepository.save(taskModel);

        return ResponseEntity.status(HttpStatus.OK).body(task); //HttpStatus OK = 200
    }
    
}
