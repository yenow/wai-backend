package com.wai.domain.user;

import com.wai.domain.common.BaseEntity;
import com.wai.domain.fileUpload.FileUpload;
import com.wai.dto.post.PostDto;
import com.wai.dto.reply.ReplyDto;
import com.wai.dto.user.UserDto;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.likey.Likey;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import com.wai.domain.userRole.UserRole;
import com.wai.domain.wiseSaying.WiseSaying;
import com.wai.dto.user.UserRequestDto;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Getter @Builder @NoArgsConstructor @AllArgsConstructor @ToString(exclude = {"posts", "replys", "userEnneagramTests", "likeys"})
@DynamicUpdate @DynamicInsert
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles = new ArrayList<>();
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<Post>();
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Reply> replys = new ArrayList<Reply>();
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserEnneagramTest> userEnneagramTests = new ArrayList<UserEnneagramTest>();;
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Likey> likeys = new ArrayList<>();
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<WiseSaying> wiseSayings = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "profile_image_file_id")
    private FileUpload profileImageFile;

    @Column(unique = true, nullable = false, length = 200)
    private String userKey;
    @Column(unique = true, length = 200)
    private String email;
    @Column(nullable = false, length = 200)
    private String password;
    @Column(length = 50)
    private String nickname;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "bit(1) default 0")
    private Boolean isMember = false;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "bit(1) default 1")
    private Boolean isActivated = true;

    public UserDto toDto() {
        return UserDto.builder()
                .userId(userId)
                .userKey(userKey)
                .email(email)
//                .password(password)
                .nickname(nickname)
                .isMember(isMember)
                .isActivated(isActivated)
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

    public void updateUser(UserRequestDto userRequestDto) {
        nickname = userRequestDto.getNickname();
    }

    public void updateProfileImage(FileUpload profileImageFile) {
        this.profileImageFile = profileImageFile;
    }
}