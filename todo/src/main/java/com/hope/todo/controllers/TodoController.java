package com.hope.todo.controllers;

import com.hope.todo.model.Todo;
import com.hope.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TodoController {


    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todo")
    public ResponseEntity<?> saveTodo(@RequestBody Todo todo){
        ResponseEntity responseEntity;

            Todo todo1 = todoService.saveTodo(todo);
            responseEntity = new ResponseEntity<Todo>(todo1 , HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping("/todo")
    public ResponseEntity<?> getAllTodo(){
    ResponseEntity listResponseEntity;

    List<Todo> allTodo=todoService.getAllTodo();

    listResponseEntity = new ResponseEntity<List<Todo>>(allTodo, HttpStatus.OK);

    return listResponseEntity;
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") int id)
    {
        ResponseEntity responseEntity;

        Todo todo=todoService.deleteTodo(id);
        responseEntity=new ResponseEntity<Todo>(todo, HttpStatus.OK);

        return responseEntity;
    }

    @PutMapping("todo/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable("id") int id, @RequestBody Todo todo)
    {
        ResponseEntity responseEntity;

        Todo todo1= todoService.updateTodo(id, todo);
        responseEntity=new ResponseEntity<Todo>(todo1, HttpStatus.OK);
        return responseEntity;
    }
}
