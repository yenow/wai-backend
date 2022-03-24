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
}
