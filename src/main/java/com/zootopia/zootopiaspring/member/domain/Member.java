package com.zootopia.zootopiaspring.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY : 디비가 키값을 알아서 생성해줌
    private Long id;
    // @Column(name = "username")
    private String email;
    private String nickname;
    private String password;

    @Column(length = 500, nullable = true)
    private String a_type;
    private String name;

    @Builder
    public Member(Long id, String email, String nickname, String password, String name) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.name = name;
    }
}
