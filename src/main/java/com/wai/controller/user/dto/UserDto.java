package com.wai.controller.user.dto;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.enneagramTest.dto.EnneagramTestDto;
import com.wai.controller.post.dto.PostDto;
import com.wai.controller.reply.dto.ReplyDto;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.user.Gender;
import com.wai.domain.userRole.UserRole;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter @Builder @ToString @NoArgsConstructor @AllArgsConstructor
public class UserDto extends ResponseDto {

    private Long userId;
    private String userKey;
    private String email;
    private String nickname;
    private String password;
    private Integer myEnneagramType;
    private Boolean isMember;
    private Boolean isActivated;


    private List<UserRoleDto> userRoleDtos;
    private List<PostDto> posts;
    private List<ReplyDto> replys;
    private List<EnneagramTestDto> enneagramTests;

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
