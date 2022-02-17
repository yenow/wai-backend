package com.wai.domain.likey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeyRepository extends JpaRepository<Likey, Long>, LikeyCustomRepository {
}
