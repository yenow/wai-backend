package com.wai.domain.userBan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BanUserRepository extends JpaRepository<BanUser, Long>, BanUserCustomRepository {
}
