package com.wai.dummyData;

import com.wai.domain.enneagram.Enneagram;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.enneagramTest.TestType;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.reply.Reply;
import com.wai.domain.reply.ReplyRepository;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import com.wai.domain.userEnneagramTest.UserEnneagramTestRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Getter
@Component
@RequiredArgsConstructor
public class DummyData {
    private List<User> users = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private List<Reply> replys = new ArrayList<>();

    final private UserRepository userRepository;
    final private PostRepository postRepository;
    final private ReplyRepository replyRepository;
    final private UserEnneagramTestRepository userEnneagramTestRepository;

    public void initUsers() {
        // User user = User.builder().userKey(UUID.randomUUID().toString()).nickname("nickname").build();

        IntStream.rangeClosed(0, 9).forEach(value -> {
            User user = User.builder().userKey(UUID.randomUUID().toString()).nickname("nickname"+value).password("passwrod"+value).build();
            userRepository.save(user);
            users.add(user);
        });
    }

    public void initPosts() {
        IntStream.rangeClosed(0, 100).forEach(value -> {
            User user = users.get(value % users.size());
            Post post = Post.builder().user(user).title("title"+value).content("content"+value).author(user.getNickname()).build();
            postRepository.save(post);

            user.getPosts().add(post);
            posts.add(post);
        });
    }

    public void initReply() {
        IntStream.rangeClosed(0, 100).forEach(value -> {
            User user = users.get(value % users.size());
            Post post = posts.get(value % posts.size());
            Reply reply = Reply.builder().user(user).post(post).replyContent("replyContent"+value).author(user.getNickname()).build();
            replyRepository.save(reply);

            replys.add(reply);
            user.getReplys().add(reply);
            post.getReplys().add(reply);
        });
    }

    public void initUserEnneagramTests() {
        List<EnneagramTest> enneagramTests = new ArrayList<>();
        IntStream.rangeClosed(0, 9).forEach(value -> {
            int enneagramType = value % 9 + 1;
            EnneagramTest enneagramTest = EnneagramTest.builder().testType(TestType.select).myEnneagramType(enneagramType).build();
            enneagramTests.add(enneagramTest);
        });

        EnneagramTest enneagramTest = EnneagramTest.builder().testType(TestType.select).myEnneagramType(2).build();
        users.get(0).doEnneagramTest(enneagramTest);

        users.forEach(user -> {
            int index = users.indexOf(user);
            user.doEnneagramTest(enneagramTests.get(index));
            userRepository.save(user);
        });
    }
}
