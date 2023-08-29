package com.application.springazuredocker.tag.infrastructure.repository;

import com.application.springazuredocker.tag.infrastructure.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {
    @Query(value = "SELECT * FROM tag WHERE uuid = ?1", nativeQuery = true)
    TagEntity findByUuid(String uuid);

    @Query(value = "SELECT * FROM tag WHERE name = ?1", nativeQuery = true)
    TagEntity findByName(String name);

    @Query(value = "DELETE FROM tag WHERE uuid = ?1", nativeQuery = true)
    void deleteByUuid(String uuid);
}
