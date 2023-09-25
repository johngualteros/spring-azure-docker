package com.application.springazuredocker.comment.infrastructure.repository;

import com.application.springazuredocker.comment.infrastructure.entity.CommentEntity;
import com.application.springazuredocker.tag.infrastructure.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query(value = "SELECT * FROM comment WHERE uuid = ?1", nativeQuery = true)
    CommentEntity findByUuid(String uuid);
    @Query(value = "DELETE FROM comment WHERE uuid = ?1", nativeQuery = true)
    void deleteByUuid(String uuid);
}

