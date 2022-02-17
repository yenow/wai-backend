package com.wai.controller.user.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wai.controller.dto.ResponseDto;
import com.wai.controller.enneagramTest.dto.EnneagramTestResponseDto;
import com.wai.controller.post.dto.PostResponseDto;
import com.wai.controller.reply.dto.ReplyResponseDto;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.user.Gender;
import com.wai.domain.user.User;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto extends ResponseDto {

    private Long userId;
    private String userKey;
    private String password;
    private Integer myEnneagramType;
    private String email;
    private String phoneNumber;
    private String nickname;
    private String birthDay;
    private Gender gender;

    private List<PostResponseDto> posts;
    private List<ReplyResponseDto> replys;
    private List<EnneagramTestResponseDto> enneagramTests;

    public UserResponseDto setPostDtos(List<PostResponseDto> postDtos) {
        this.posts = postDtos;
        return this;
    }

    public UserResponseDto setReplyDtos(List<ReplyResponseDto> replyDtos) {
        this.replys = replyDtos;
        return this;
    }

    public UserResponseDto setEnneagramTestDtos(List<EnneagramTestResponseDto> enneagramTestDtos) {
        this.enneagramTests = enneagramTestDtos;
        return this;
    }
}
