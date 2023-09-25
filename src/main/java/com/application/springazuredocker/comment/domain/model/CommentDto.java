package com.application.springazuredocker.comment.domain.model;

import com.application.springazuredocker.comment.domain.aggregates.CommentContentValueObject;
import com.application.springazuredocker.comment.domain.aggregates.CommentDateValueObject;
import com.application.springazuredocker.shared.domain.aggregates.UuidV3ValueObject;
import com.application.springazuredocker.user.infrastructure.entity.UserEntity;

import java.util.Date;

public class CommentDto {
    private UuidV3ValueObject uuid;
    private CommentContentValueObject content;
    private UserEntity owner;
    private CommentDateValueObject createdAt;
    private CommentDateValueObject updatedAt;
    public String getUuid() {
        return uuid.value;
    }
    public String getContent() {
        return content.value;
    }
    public UserEntity getOwner() {
        return owner;
    }
    public Date getCreatedAt() {
        return createdAt.value;
    }
    public Date getUpdatedAt() {
        return updatedAt.value;
    }

    public CommentDto(UuidV3ValueObject uuid, CommentContentValueObject content, UserEntity owner, CommentDateValueObject createdAt, CommentDateValueObject updatedAt) {
        this.uuid = uuid;
        this.content = content;
        this.owner = owner;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
