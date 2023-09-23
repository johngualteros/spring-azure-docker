package com.application.springazuredocker.comment.domain.model;

import com.application.springazuredocker.comment.domain.aggregates.CommentContentValueObject;
import com.application.springazuredocker.comment.domain.aggregates.CommentDateValueObject;
import com.application.springazuredocker.shared.domain.aggregates.UuidV3ValueObject;
import com.application.springazuredocker.user.infrastructure.entity.UserEntity;

public class CommentDto {
    private UuidV3ValueObject uuid;
    private CommentContentValueObject content;
    private UserEntity owner;
    private CommentDateValueObject createdAt;
    private CommentDateValueObject updatedAt;
}
