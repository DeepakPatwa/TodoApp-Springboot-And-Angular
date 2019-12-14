package com.hope.todo.service;

import com.hope.todo.model.Todo;

import javax.sound.midi.Track;
import java.util.List;

public interface TodoService {

    Todo saveTodo (Todo todo);

    List<Todo> getAllTodo();

    Todo updateTodo(int id, Todo todo);

    Todo deleteTodo(int id);

}
