package com.zootopia.zootopiaspring.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcTemplateMemberRepositoryTest {

    @Autowired
    MemberRepository jdbcTemplateMemberRepository;

    @Test
    void save() {
        assertNotNull(jdbcTemplateMemberRepository);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findAll() {
    }
}