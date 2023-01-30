package com.example.todolist.domain.todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "todo") // Todo 클래스 엔티티와 매핑
public class Todo {

	// todo 테이블의 PK, AUTO_INCREMENT 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(updatable = false)
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	// TO DO LIST 성격에 맞는 카테고리(WORK, REST)
	@Column(name = "category")
    private TodoCategory category;

    // TO DO LIST 내용
    @Column
    private String content;

	// 완료여부
    @Column
    private Boolean completed = false;


    public Todo (TodoCategory category, String content) {
        this.category = category;
        this.content = content;
    }
}

