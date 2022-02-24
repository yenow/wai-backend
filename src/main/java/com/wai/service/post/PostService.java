package com.wai.service.post;

import com.wai.controller.post.dto.PostRequestDto;
import com.wai.controller.post.dto.PostDto;
import com.wai.controller.post.dto.PostSaveRequestDto;
import com.wai.controller.post.dto.PostSearchType;
import com.wai.domain.likey.Likey;
import com.wai.domain.likey.LikeyRepository;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.reply.ReplyRepository;
import com.wai.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;
    private final LikeyRepository likeyRepository;

    @Transactional
    public PostDto save(PostSaveRequestDto postSaveRequestDto) {
        if (postSaveRequestDto.getPostId() != null) {
            Post post = postRepository.findById(postSaveRequestDto.getPostId()).get();
            post.updatePost(postSaveRequestDto);
            return convertPostResponseDto(post);
        }

        return convertPostResponseDto(postRepository.save(postSaveRequestDto.toEntity()));
    }

    @Transactional
    public PostDto readPost(PostRequestDto postRequestDto) {
        Post post = postRepository.findById(postRequestDto.getPostId()).get();

        if (postRequestDto.getCanUpdateCount()) {
            post.increaseClickCount();
        }

        return post.toDto()
                .setUserDto(post.getUser().toDto())
                .setReplyDtos(post.getReplyDtos().stream().map(replyResponseDto ->
                        replyResponseDto.setPostDto(post.toDto())).collect(Collectors.toList()));
    }

    public List<PostDto> readInitPosts(PostRequestDto postRequestDto) {
        List<Post> posts;
        if (postRequestDto.getPostSearchType().equals(PostSearchType.popular)) {
            posts =  postRepository.initPopularPosts(postRequestDto);
        } else {
            posts =  postRepository.readInitPosts(postRequestDto);
        }
        return convertPostResponseDtos(posts);
    }

    public List<PostDto> readMoreNewPosts(PostRequestDto postRequestDto) {
        List<Post> posts;
        if (postRequestDto.getPostSearchType().equals(PostSearchType.popular)) {
            return new ArrayList<>();
        }

        if (postRequestDto.getEndPostId() == null && postRequestDto.getStartPostId() == null) {
            posts = postRepository.readInitPosts(postRequestDto);
        } else {
            posts = postRepository.readMoreNewPosts(postRequestDto);
        }
        return convertPostResponseDtos(posts);
    }

    public List<PostDto> readMoreOldPosts(PostRequestDto postRequestDto) {
        List<Post> posts;
        if (postRequestDto.getPostSearchType().equals(PostSearchType.popular)) {
            return new ArrayList<>();
        }

        if (postRequestDto.getEndPostId() == null && postRequestDto.getStartPostId() == null) {
            posts =  postRepository.readInitPosts(postRequestDto);
        } else {
            posts =  postRepository.readMoreOldPosts(postRequestDto);
        }
        return convertPostResponseDtos(posts);
    }

    public List<PostDto> initPopularPosts(PostRequestDto postRequestDto) {
        List<Post> posts =  postRepository.initPopularPosts(postRequestDto);

        return convertPostResponseDtos(posts);
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

    @Transactional
    public PostDto deletePost(PostRequestDto postRequestDto) {
        Post post = postRepository.findById(postRequestDto.getPostId()).get();
        post.deletePost();
        return convertPostResponseDto(post);
    }

    @Transactional
    public PostDto updatePost(PostSaveRequestDto postSaveRequestDto) {
        Post post = postRepository.findById(postSaveRequestDto.getPostId()).get();
        post.updatePost(postSaveRequestDto);
        return convertPostResponseDto(post);
    }


    private List<PostDto> convertPostResponseDtos(List<Post> posts) {
        List<PostDto> postDtos = new ArrayList<>();
        posts.forEach((post) -> {
            postDtos.add(convertPostResponseDto(post));
        });
        return postDtos;
    }

    private PostDto convertPostResponseDto(Post post) {
        return post.toDto()
                .setUserDto(post.getUser().toDto())
                .setReplyDtos(post.getReplyDtos());
    }
}