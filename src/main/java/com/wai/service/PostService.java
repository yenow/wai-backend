package com.wai.service;

import com.wai.domain.tag.Tag;
import com.wai.domain.tag.TagRepository;
import com.wai.dto.post.PostRequestDto;
import com.wai.dto.post.PostDto;
import com.wai.dto.post.PostSaveRequestDto;
import com.wai.dto.post.PostSearchType;
import com.wai.domain.likey.Likey;
import com.wai.domain.likey.LikeyRepository;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.reply.ReplyRepository;
import com.wai.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final ReplyRepository replyRepository;
    private final LikeyRepository likeyRepository;

    @Transactional
    public PostDto getPost(PostRequestDto postRequestDto) {
        PostDto postDto = postRepository.getPostDto(postRequestDto).orElseThrow();
        // 조회수
//        if (postRequestDto.getCanUpdateCount()) {
//            post.increaseClickCount();
//        }
        return postDto;
    }

    public List<PostDto> posts(PostRequestDto postRequestDto) {
        return postRepository.getPostDtos(postRequestDto);
    }

    @Transactional
    public PostDto createPost(PostSaveRequestDto postSaveRequestDto) {
        List<Tag> tags = getTags(postSaveRequestDto.getTag());
        Post post = postSaveRequestDto.toEntity();
        post.updateTags(tags);
        postRepository.save(post);
        return new PostDto(post);
    }

    @Transactional
    public PostDto updatePost(PostSaveRequestDto postSaveRequestDto) {
        List<Tag> tags = getTags(postSaveRequestDto.getTag());
        Post post = postRepository.findById(postSaveRequestDto.getPostId()).get();
        post.updatePost(postSaveRequestDto);
        post.updateTags(tags);
        return new PostDto(post);
    }

    public List<Tag> getTags(String tagString) {
        return Arrays.stream(tagString.split("#"))
                .map(String::trim)
                .filter(StringUtils::isNotEmpty)
                .map(str -> Tag.builder().tagName(str.trim()).build())
                .collect(Collectors.toList());
    }

    @Transactional
    public PostDto deletePost(PostRequestDto postRequestDto) {
        Post post = postRepository.findById(postRequestDto.getPostId()).get();
        post.deletePost();
        return new PostDto(post);
    }

    @Transactional
    public PostDto reportPost(PostRequestDto postRequestDto) {
        Post post = postRepository.findById(postRequestDto.getPostId()).get();
        post.reportPost();
        return new PostDto(post);
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