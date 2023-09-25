package com.application.springazuredocker.comment.domain.mappers;

import com.application.springazuredocker.comment.domain.model.CommentDto;
import com.application.springazuredocker.comment.infrastructure.entity.CommentEntity;

public class CommentDtoToEntity {
    /**
     * method to map a CommentDto to a CommentEntity
     * @param commentDto
     * @return CommentEntity
     * */
    public static CommentEntity map(CommentDto commentDto) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setUuid(commentDto.getUuid());
        commentEntity.setContent(commentDto.getContent());
        commentEntity.setCreatedAt(commentDto.getCreatedAt());
        commentEntity.setUpdatedAt(commentDto.getUpdatedAt());
        commentEntity.setOwner(commentDto.getOwner());
        return commentEntity;
    }
}
