package com.example.todolist.domain.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface TodoRepository extends JpaRepository<Todo, Long>{

	// Todo의 completed 업데이트
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update todo t SET t.completed = ?1 WHERE t.idx = ?2")
    void updateCompleted(Boolean completed, Long idx);

    //	 Todo의 category와 content 업데이트
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE todo t set t.category = ?1, t.content = ?2 WHERE t.idx = ?3")
    void updateTodoCategorytAndContent(TodoCategory category, String content, Long idx);

    Todo findByIdx(Long idx);
    List<Todo> findAllByCreatedDate(String createdDate);
}
