package com.wai.service.post;

import com.wai.controller.enneagramTest.dto.EnneagramTestResponseDto;
import com.wai.controller.post.dto.PostRequestDto;
import com.wai.controller.post.dto.PostResponseDto;
import com.wai.controller.post.dto.PostSaveRequestDto;
import com.wai.controller.reply.dto.ReplyResponseDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.likey.Likey;
import com.wai.domain.likey.LikeyRepository;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.reply.Reply;
import com.wai.domain.reply.ReplyRepository;
import com.wai.domain.user.User;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * packageName : com.wai.service.post
 * fileName : PostService
 * author : 윤신영
 * date : 2021-12-03
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-03   윤신영     최초 생성
 */
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;
    private final LikeyRepository likeyRepository;

    @Transactional
    public Post save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity());
    }

    @Transactional
    public PostResponseDto readPost(Long postId) {
        // todo. 게시글 조회수 추가, 특정시간 이후 조회수 추가
        Post post = postRepository.findById(postId).get();
        post.increaseClickCount();

        return post.toDto()
                .setUserDto(post.getUser().toDto())
                .setReplyDtos(post.getReplyDtos());
    }

    public List<PostResponseDto> readInitPosts(PostRequestDto postRequestDto) {
        List<Post> posts =  postRepository.readPostsInit(postRequestDto);
        return convertPostResponseDtos(posts);
    }

    public List<PostResponseDto> readMoreNewPosts(PostRequestDto postRequestDto) {
        List<Post> posts =  postRepository.readMoreNewPosts(postRequestDto);
        return convertPostResponseDtos(posts);
    }

    public List<PostResponseDto> readMoreOldPosts(PostRequestDto postRequestDto) {
        List<Post> posts =  postRepository.readMoreOldPosts(postRequestDto);
        return convertPostResponseDtos(posts);
    }

    private List<PostResponseDto> convertPostResponseDtos(List<Post> posts) {
        List<PostResponseDto> postDtos = new ArrayList<>();
        posts.forEach((post) -> {
            postDtos.add(post.toDto()
                    .setUserDto(post.getUser().toDto())
                    .setReplyDtos(post.getReplyDtos()));
        });
        return postDtos;
    }

    @Transactional
    public void addLikey(Long postId, Long userId) {
        Optional<Likey> likey = likeyRepository.findByUserIdAndPostId(userId,postId);

        if(likey.isEmpty()) {
            likeyRepository.save(Likey.builder()
                    .post(Post.builder().postId(postId).build())
                    .user(User.builder().userId(userId).build())
                    .build()
            );
        }
    }

    @Transactional
    public void removeLikey(Long postId, Long userId) {
        Optional<Likey> likey = likeyRepository.findByUserIdAndPostId(userId,postId);

        likey.ifPresent(likeyRepository::delete);
    }
}