package com.wai.domain.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wai.common.BaseEntity;
import com.wai.controller.post.dto.PostDto;
import com.wai.controller.reply.dto.ReplyDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.likey.Likey;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter @Builder @NoArgsConstructor @AllArgsConstructor @ToString(exclude = {"posts", "replys", "userEnneagramTests", "likeys"})
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Builder.Default @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<Post>();
    @Builder.Default @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Reply> replys = new ArrayList<Reply>();
    @Builder.Default @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserEnneagramTest> userEnneagramTests = new ArrayList<UserEnneagramTest>();;
    @Builder.Default @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Likey> likeys = new ArrayList<>();

    @Column(unique = true, nullable = false, length = 200)
    private String userKey;
    @Column(length = 200)
    private String password;
    @Column(length = 200)
    private String email;
    @Column(length = 50)
    private String nickname;

    public UserDto toDto() {
        return UserDto.builder()
                .userId(userId)
                .userKey(userKey)
                .password(password)
                .email(email)
                .nickname(nickname)
                .myEnneagramType(findLastMyEnneagramType())
                .build();
    }

    public Integer findLastMyEnneagramType() {
        if (userEnneagramTests != null) {
            return userEnneagramTests.size() > 0 ? userEnneagramTests.get(userEnneagramTests.size()-1).getEnneagramTest().getMyEnneagramType() : null;
        } else {
            return null;
        }
    }

    public void saveNickname(String nickname) {
        this.nickname = nickname;
    }

    public void doEnneagramTest(EnneagramTest enneagramTest) {
        userEnneagramTests.add(UserEnneagramTest.builder().enneagramTest(enneagramTest).user(this).build());
    }

    public List<PostDto> getPostDtos() {
        return posts.stream()
                .map(post -> post.toDto())
                .filter(postResponseDto -> !postResponseDto.getIsDeleted())
                .collect(Collectors.toList());
    }

    public List<ReplyDto> getReplyDtos() {
        return replys.stream()
                .map(reply ->
                        reply.toDto()
                                .setPostDto(reply.getPost().toDto()))
                .filter(replyResponseDto -> !replyResponseDto.getIsDeleted())
                .collect(Collectors.toList());
    }
}