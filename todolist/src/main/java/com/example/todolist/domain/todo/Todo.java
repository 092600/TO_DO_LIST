package com.example.todolist.domain.todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.todolist.domain.timeEntity.TimeEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "todo") // Todo 클래스 엔티티와 매핑
@NoArgsConstructor
@AllArgsConstructor
public class Todo extends TimeEntity {

	// todo 테이블의 PK, AUTO_INCREMENT 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

	// TO DO LIST 성격에 맞는 카테고리(WORK, REST)
	@Column(name = "category")
    private TodoCategory category;

    // TO DO LIST 내용
    @Column
    private String content;

	// 완료여부
    @Column
    private Boolean completed = false;

}

// TO DO LIST의 카테고리를 위해 ToDoCategory Enumerate 생성
enum TodoCategory {
    STUDY, REST
}
