package com.wai.common;

import com.wai.dto.user.UserDto;
import com.wai.domain.post.Post;
import com.wai.domain.user.User;
import lombok.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class BeanUtilTest {
    
    @Test
    void test() {
        User user = User.builder().userId(1L).nickname("nickname").build();
        Post post = Post.builder().postId(1L).title("title").author("nickname").build();
        user.getPosts().add(post);
        
        UserDto userDto = UserDto.builder().build();
        BeanUtils.copyProperties(user, userDto, "posts", "userId");
        System.out.println("userDto = " + userDto);
        System.out.println("user = " + user);

        Child child = new Child(1L, "child");
        List<Child> children = new ArrayList<>();
        children.add(child);
        Parent parent =  Parent.builder().id(1L).name("parent").child(child).children(children).build();

        ParentDto parentDto = ParentDto.builder().build();

        BeanUtils.copyProperties(parent, parentDto, "children");
        System.out.println("parent = " + parent);
        System.out.println("parentDto = " + parentDto);

    }

    @Data
    @Builder
    static class Parent {
        Long id;
        String name;
        Child child;
        List<Child> children;
    }

    @Data
    @Builder
    static class Child {
        Long id;
        String name;
    }

    @Data
    @Builder
    static class ParentDto {
        Long id;
        String name;
        ChildDto child;
        List<ChildDto> children;
    }

    @Data
    @Builder
    static class ChildDto {
        Long id;
        String childName;
    }
}
