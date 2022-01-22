package com.wai.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wai.common.BaseEntity;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.wai.domain.user
 * fileName : User
 * author : 윤신영
 * date : 2021-12-20
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-20   윤신영     최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @OneToMany(mappedBy = "user"/*, fetch = FetchType.EAGER*/)
    /*@JsonIgnoreProperties({"user"})*/
    @JsonManagedReference
    private List<Post> posts = new ArrayList<Post>();;
    @OneToMany(mappedBy = "user")
    private List<Reply> replys = new ArrayList<Reply>();;
    @OneToMany(mappedBy = "user")
    private List<UserEnneagramTest> userEnneagramTests = new ArrayList<UserEnneagramTest>();;

    @Column(unique = true, nullable = false, length = 200)
    private String userKey;
    @Column(length = 200)
    private String password;
    @Column(length = 200)
    private String email;
    @Column(length = 13)
    private String phoneNumber;
    @Column(length = 50)
    private String nickname;
    @Column(length = 50)
    private String birthDay;
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;
}