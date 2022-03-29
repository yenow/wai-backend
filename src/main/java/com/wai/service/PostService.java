package com.wai.service;

import com.wai.common.exception.post.PostIdNotExistException;
import com.wai.common.exception.user.UserIdNotExistException;
import com.wai.domain.notice.NoticeRepository;
import com.wai.domain.postHistory.PostHistory;
import com.wai.domain.postHistory.PostHistoryRepository;
import com.wai.domain.tag.Tag;
import com.wai.dto.post.PostRequestDto;
import com.wai.dto.post.PostDto;
import com.wai.dto.post.PostSaveRequestDto;
import com.wai.dto.post.PostSearchType;
import com.wai.domain.likey.Likey;
import com.wai.domain.likey.LikeyRepository;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostHistoryRepository postHistoryRepository;
    private final LikeyRepository likeyRepository;

    @Transactional
    public PostDto getPostDto(PostRequestDto postRequestDto) {
        if (postRequestDto.getPostId() == null) throw new PostIdNotExistException();
        if (postRequestDto.getUserId() == null) throw new UserIdNotExistException();

        Optional<PostHistory> lastPostHistory = increaseClickCount(postRequestDto);
        PostDto postDto = postRepository.getPostDto(postRequestDto).orElseThrow();
        savePostHistory(postRequestDto, lastPostHistory);
        return postDto;
    }

    private Optional<PostHistory> increaseClickCount(PostRequestDto postRequestDto) {
        Optional<PostHistory> lastPostHistory = postHistoryRepository.findOneByPostIdAndUserId(postRequestDto.getPostId(), postRequestDto.getUserId());
        if (lastPostHistory.isEmpty() || LocalDateTime.now().isAfter(lastPostHistory.get().getUpdateDate().plusHours(1))) {
            Post post = postRepository.findById(postRequestDto.getPostId()).orElseThrow();
            post.increaseClickCount();
        }
        return lastPostHistory;
    }

    private void savePostHistory(PostRequestDto postRequestDto, Optional<PostHistory> lastPostHistory) {
        if (lastPostHistory.isEmpty()) {
            postHistoryRepository.save(
                PostHistory.builder()
                .post(Post.builder().postId(postRequestDto.getPostId()).build())
                .user(User.builder().userId(postRequestDto.getUserId()).build())
                .build()
            );
        } else {
            lastPostHistory.get().setUpdateDate(LocalDateTime.now());
        }
    }

    public List<PostDto> posts(PostRequestDto postRequestDto) {
        if (postRequestDto.getPostSearchType().equals(PostSearchType.popular)) {
            return postRepository.getPostDtosOrderByPopular(postRequestDto);
        }
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