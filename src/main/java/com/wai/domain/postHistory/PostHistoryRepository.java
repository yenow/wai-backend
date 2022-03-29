package com.wai.domain.postHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostHistoryRepository extends JpaRepository<PostHistory, Long>, PostHistoryCustomRepository{
}
