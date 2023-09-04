package com.application.springazuredocker.user.infrastructure.repository;

import com.application.springazuredocker.user.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByName(String name);
}
