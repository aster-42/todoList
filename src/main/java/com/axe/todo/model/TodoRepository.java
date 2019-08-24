package com.axe.todo.model;

import com.axe.todo.entity.Todo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findAll();

    @SuppressWarnings("unchecked")
    Todo save(Todo todo);

    @Transactional
    @Modifying
    @Query("update Todo as t set t.status = ?2 where t.id=?1")
    void updateById(Long id, int status);
}


