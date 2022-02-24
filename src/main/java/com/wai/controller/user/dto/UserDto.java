package com.wai.controller.user.dto;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.enneagramTest.dto.EnneagramTestDto;
import com.wai.controller.post.dto.PostDto;
import com.wai.controller.reply.dto.ReplyDto;
import com.wai.domain.user.Gender;
import lombok.*;

import java.util.List;

@Getter @Setter @Builder @ToString @NoArgsConstructor @AllArgsConstructor
public class UserDto extends ResponseDto {

    private Long userId;
    private String userKey;
    private String password;
    private Integer myEnneagramType;
    private String email;
    private String phoneNumber;
    private String nickname;
    private String birthDay;
    private Gender gender;

    private List<PostDto> posts;
    private List<ReplyDto> replys;
    private List<EnneagramTestDto> enneagramTests;

    public UserDto setPostDtos(List<PostDto> postDtos) {
        this.posts = postDtos;
        return this;
    }

    public UserDto setReplyDtos(List<ReplyDto> replyDtos) {
        this.replys = replyDtos;
        return this;
    }

    public UserDto setEnneagramTestDtos(List<EnneagramTestDto> enneagramTestDtos) {
        this.enneagramTests = enneagramTestDtos;
        return this;
    }
}
