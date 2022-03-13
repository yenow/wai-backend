package com.wai.controller;

import com.wai.dto.hello.HelloEnum;
import com.wai.dto.hello.HelloRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string("hello"));
    }

    @Test
    public void helloReturn() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloReturn2() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(name)))
                .andExpect(jsonPath("$.amount", equalTo(amount)));
    }
    
    @DisplayName("enum 테스트")
    @Test
    public void testEnum() throws Exception {
        HelloEnum helloEnum = HelloEnum.hi;
        // HelloEnum.sout();
        HelloRequestDto helloRequestDto = new HelloRequestDto("hi",helloEnum);

        mvc.perform(get("/hello/enumTest")
                .param("name","hi")
                .param("helloEnum","hi"))
                .andExpect(status().isOk());
    }

    @DisplayName("enum 테스트2")
    @Test
    public void testEnum2() throws Exception {
        HelloEnum helloEnum = HelloEnum.hi;
//        HelloEnum.sout();
        HelloRequestDto helloRequestDto = new HelloRequestDto("hi",helloEnum);

        mvc.perform(get("/hello/enumTest")
                .param("name","hi"))
                .andExpect(status().isOk());
    }
}