package com.wai.common;

import com.wai.controller.user.dto.UserDto;
import com.wai.domain.post.Post;
import com.wai.domain.user.User;
import lombok.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;

import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelMapperTest {

    @Test
    void modelMapperTest() {
        /* modelMapper 설정 */
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        TypeMap<User, UserDto> propertyMapper = modelMapper.createTypeMap(User.class, UserDto.class);
        propertyMapper.addMappings(mapper -> mapper.skip(UserDto::setPostDtos));
        propertyMapper.addMappings(mapper -> mapper.skip(UserDto::setPosts));

        
        User user = User.builder().userId(1L).nickname("nickname").build();
        Post post = Post.builder().postId(1L).title("title").author("nickname").build();
        user.getPosts().add(post);

        UserDto userDto = modelMapper.map(user, UserDto.class);
        System.out.println("userResponseDto = " + userDto);
        assertEquals(user.getNickname(), userDto.getNickname());
//        assertEquals(user.getPosts().get(0).getTitle(), userDto.getPosts().get(0).getTitle());

        /* example */
        Child child = new Child(1L, "child");
        List<Child> children = new ArrayList<>();
        children.add(child);
        Parent parent =  Parent.builder().id(1L).name("parent").child(child).children(children).build();

        ParentDto parentDto = modelMapper.map(parent, ParentDto.class);

        System.out.println("parent = " + parent);
        System.out.println("parentDto = " + parentDto);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Parent {
        private Long id;
        private  String name;
        private Child child;
        private List<Child> children;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Child {
        private Long id;
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class ParentDto {
        private Long id;
        private String name;
        private ChildDto child;
        private List<ChildDto> children;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class ChildDto {
        private Long id;
        private String childName;
    }
}
