package com.wai.dto.user;

import com.wai.domain.user.User;
import com.wai.dto.ResponseDto;
import com.wai.dto.enneagramTest.EnneagramTestDto;
import com.wai.dto.post.PostDto;
import com.wai.dto.reply.ReplyDto;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.userRole.UserRole;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter @Builder @ToString @NoArgsConstructor @AllArgsConstructor
public class UserDto {

    private Long userId;
    private String userKey;
    private String email;
    private String nickname;
//    private String password;
    private Integer myEnneagramType;
    private Long profileImageFileId;
    private Boolean isMember;
    private Boolean isActivated;


    private List<UserRoleDto> userRoleDtos;
    private List<PostDto> posts;
    private List<ReplyDto> replys;
    private List<EnneagramTestDto> enneagramTests;

    public UserDto(User user) {
        userId = user.getUserId();
        userKey = user.getUserKey();
        email = user.getEmail();
        nickname = user.getNickname();
        myEnneagramType = user.findLastMyEnneagramType();
        if (user.getProfileImageFile() != null) {
            profileImageFileId = user.getProfileImageFile().getFileId();
        }
        isMember = user.getIsMember();
        isActivated = user.getIsActivated();
    }

    public UserDto setUserRoleDtos(List<UserRole> userRoles) {
        this.userRoleDtos = userRoles.stream().map(UserRole::toDto)
                .collect(Collectors.toList());
        return this;
    }

    public UserDto setPostDtos(List<Post> posts) {
        this.posts = posts.stream().map(Post::toDto)
                .filter(postResponseDto -> !postResponseDto.getIsDeleted()).collect(Collectors.toList());;
        return this;
    }

    public UserDto setReplyDtos(List<Reply> replys) {
        this.replys = replys.stream()
                .map(reply ->
                        reply.toDto()
                                .setPostDto(reply.getPost().toDto()))
                .filter(replyResponseDto -> !replyResponseDto.getIsDeleted())
                .collect(Collectors.toList());
        return this;
    }

    public UserDto setEnneagramTestDtos(List<EnneagramTestDto> enneagramTestDtos) {
        this.enneagramTests = enneagramTestDtos;
        return this;
    }
}
