package com.wai;

import com.wai.controller.enneagramTest.dto.EnneagramTestDto;
import com.wai.controller.post.dto.PostDto;
import com.wai.controller.reply.dto.ReplyDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.user.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
public class SpringConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setPreferNestedProperties(false);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        TypeMap<User, UserDto> userPropertyMapper = modelMapper.createTypeMap(User.class, UserDto.class);
        userPropertyMapper.addMappings(mapping -> mapping.skip(UserDto::setPostDtos));
        userPropertyMapper.addMappings(mapping -> mapping.skip(UserDto::setPosts));
        userPropertyMapper.addMappings(mapping -> mapping.skip(UserDto::setReplyDtos));
        userPropertyMapper.addMappings(mapping -> mapping.skip(UserDto::setReplys));
        userPropertyMapper.addMappings(mapping -> mapping.skip(UserDto::setEnneagramTests));
        userPropertyMapper.addMappings(mapping -> mapping.skip(UserDto::setEnneagramTestDtos));

        TypeMap<Post, PostDto> postPropertyMapper = modelMapper.createTypeMap(Post.class, PostDto.class);
        postPropertyMapper.addMappings(mapping -> mapping.skip(PostDto::setUserDto));
        postPropertyMapper.addMappings(mapping -> mapping.skip(PostDto::setReplyDtos));
        postPropertyMapper.addMappings(mapping -> mapping.skip(PostDto::setTags));
        postPropertyMapper.addMappings(mapping -> mapping.skip(PostDto::setLikeys));

        TypeMap<Reply, ReplyDto> replyPropertyMapper = modelMapper.createTypeMap(Reply.class, ReplyDto.class);
        replyPropertyMapper.addMappings(mapping -> mapping.skip(ReplyDto::setUserDto));
        replyPropertyMapper.addMappings(mapping -> mapping.skip(ReplyDto::setPostDto));

        return modelMapper;
    }
}
