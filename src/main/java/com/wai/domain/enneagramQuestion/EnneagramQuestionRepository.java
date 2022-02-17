package com.wai.domain.enneagramQuestion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnneagramQuestionRepository extends JpaRepository<EnneagramQuestion, Long>, EnneagramQuestionCustomRepository {
}
