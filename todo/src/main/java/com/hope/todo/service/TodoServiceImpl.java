package com.hope.todo.service;
import com.hope.todo.model.Todo;
import com.hope.todo.repositorie.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository)
    {
        this.todoRepository=todoRepository;
    }

    @Override
    public Todo saveTodo(Todo todo) {

//        if(todoRepository.existsByTitle(todo.getTitle()))
        Todo todo1=todoRepository.save(todo);

        return todo1;
    }

    @Override
    public List<Todo> getAllTodo() {

        List<Todo> todoList=todoRepository.findAll();

        return todoList;
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {

        Todo todo1=todoRepository.findById(id);

//        if(!todo.equals(todo1))
//        {
            Todo updatedTodo=todoRepository.save(todo);
            return updatedTodo;
//        }


    }

    @Override
    public Todo deleteTodo(int id) {

        Todo todo1=todoRepository.findById(id);
        if(!todo1.equals(null))
        {
            todoRepository.deleteById(id);
            return todo1;
        }
        return null;
    }
}
