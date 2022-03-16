package com.wai.dummyData;

import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
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
@Component
@RequiredArgsConstructor
public class DummyPost {

    private final DummyUser dummyUser;
    private final PostRepository postRepository;

    @Transactional
    public List<Post> createDummyPosts() {
        List<User> dummyUsers = dummyUser.createDummyUsers();
        List<Post> dummyPosts = new ArrayList<>(Arrays.asList(
            buildPost(dummyUsers.get(0),"제목입니다.","내용입니다.",false,false)
            ,buildPost(dummyUsers.get(1),"제목입니다2.","내용입니다2.",false,false)
        ));

        return dummyPosts;
    }

    private Post buildPost(User user, String title, String content, Boolean isDelete, Boolean isReported) {
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
