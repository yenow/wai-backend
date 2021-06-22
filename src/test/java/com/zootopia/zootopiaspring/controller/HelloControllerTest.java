package com.zootopia.zootopiaspring.controller;

import org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/* @WebMvcTest는 MVC쪽만 슬라이스(slice) 테스트를 할 때  */
// @WebMvcTest

/* @SpringBootTest + @AutoConfigureMockMvc는 통합테스트 할때  */
/*
@SpringBootTest
@AutoConfigureMockMvc
*/
@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void Hello_리턴() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello").param("name",hello))
                .andExpect(status().isOk()).andExpect(jsonPath("$.name",is(hello)));

        /* jsonPath : json값 검증
        *  param : 파라미터 추가 */
    }
}