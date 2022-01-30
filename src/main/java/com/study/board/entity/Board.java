package com.study.board.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Entity는 테이블을 의미한다. 자바 영속성 JPA에서 이 어노테이션은 이 클래스가 DB의 테이블을 의미한다는 표시
@Data // [lombok] getter setter 추가
public class Board {

    @Id // primary key라는 것을 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 전략 - mariadb에서 쓰는 identity로 해줌
    private int id;

    private String title;

    private String content;

}
