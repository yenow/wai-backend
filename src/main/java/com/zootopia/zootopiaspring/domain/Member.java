package com.zootopia.zootopiaspring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY : 디비가 키값을 알아서 생성해줌
    private Long id;
    // @Column(name = "username")
    private String name;

}
