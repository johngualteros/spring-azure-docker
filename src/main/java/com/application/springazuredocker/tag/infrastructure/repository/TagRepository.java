package com.application.springazuredocker.tag.infrastructure.repository;

import com.application.springazuredocker.tag.infrastructure.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}
