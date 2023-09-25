package com.application.springazuredocker.comment.application.create;

import com.application.springazuredocker.comment.domain.mappers.CommentDtoToEntity;
import com.application.springazuredocker.comment.domain.model.CommentDto;
import com.application.springazuredocker.comment.domain.records.CreateCommentResponse;
import com.application.springazuredocker.comment.infrastructure.entity.CommentEntity;
import com.application.springazuredocker.comment.infrastructure.repository.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateComment {
    /**
     * Logger for register the logs in the use case
     * */
    Logger logger = LoggerFactory.getLogger(CreateComment.class);
    /**
     * Repository of comments for inject when the class is build
    * */
    public CommentRepository commentRepository;
    /**
     * Constructor method
     * */
    public CreateComment(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    /**
     * Method for create a comment
     * */
    public CreateCommentResponse execute(CommentDto commentDto) {
        CommentEntity commentEntity = CommentDtoToEntity.map(commentDto);
        commentRepository.save(commentEntity);
        return commentEntity.toCreateCommentResponse();
    }
}
