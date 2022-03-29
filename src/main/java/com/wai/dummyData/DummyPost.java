package com.wai.dummyData;

import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.tag.Tag;
import com.wai.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class DummyPost {

    static public List<Post> createDummyPosts(User user) {
        return new ArrayList<>(Arrays.asList(
            buildPost(user,"제목입니다.","내용입니다.",false,false)
            ,buildPost(user,"삭제된 글입니다.","삭제된 글입니다.",true,false)
            ,buildPost(user,"신고된 글입니다.","신고된 글입니다.",false,true)
        ));
    }
    static private Post buildPost(User user, String title, String content, Boolean isDelete, Boolean isReported) {
        return Post.builder()
                .title(title)
                .content(content)
                .user(user)
                .isDeleted(isDelete)
                .isReported(isReported)
                .clickCount(0)
                .author(user.getNickname())
                .authorEnneagramType(user.getUserEnneagramTests().get(0).getEnneagramTest().getMyEnneagramType())
                .build();
    }
}
