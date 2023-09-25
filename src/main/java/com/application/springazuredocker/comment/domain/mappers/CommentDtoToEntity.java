package com.application.springazuredocker.comment.domain.mappers;

import com.application.springazuredocker.comment.domain.model.CommentDto;
import com.application.springazuredocker.comment.infrastructure.entity.CommentEntity;

public class CommentDtoToEntity {
    public static CommentEntity map(CommentDto commentDto) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setUuid(commentDto.getUuid());
        return commentEntity;
    }
}
