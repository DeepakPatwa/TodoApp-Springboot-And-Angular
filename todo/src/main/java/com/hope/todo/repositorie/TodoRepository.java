package com.hope.todo.repositorie;

import com.hope.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {

    boolean existsByTitle(String Tital);

    Todo save(Todo todo);

    Todo findById(int id);

    List<Todo> findAll();

    List<Todo> findByCompleted(boolean completed);
}
