package com.zootopia.zootopiaspring.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

class JdbcMemberRepositoryTest {

    private DataSource dataSource;

    @Autowired
    public JdbcMemberRepositoryTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private JdbcMemberRepository memberRepository = new JdbcMemberRepository(dataSource);

    @BeforeAll
    void before () {

    }

    @Test
    void save() {

    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {

    }

    @Test
    void findByName() {
    }
}