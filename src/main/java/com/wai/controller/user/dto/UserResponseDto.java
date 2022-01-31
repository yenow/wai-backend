package com.wai.controller.user.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

/**
 * packageName : com.wai.controller.user.dto
 * fileName : UserResponseDto
 * author : 윤신영
 * date : 2022-01-24
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-24   윤신영     최초 생성
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long userId;
    private List<PostResponseDto> posts;
    private List<ReplyResponseDto> replys;
    private EnneagramTestResponseDto enneagramTest;
    private String userKey;
    private String password;
    private String email;
    private String phoneNumber;
    private String nickname;
    private String birthDay;
    private Gender gender;

    public UserResponseDto setPostDtos(List<PostResponseDto> posts) {
        this.posts = posts;
        return this;
    }

    public UserResponseDto setReplyDtos(List<ReplyResponseDto> replys) {
        this.replys = replys;
        return this;
    }
}
