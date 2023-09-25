package com.application.springazuredocker.comment.domain.records;

public record CommentResponse(
    String uuid,
    String content,
    String owner,
    String createdAt,
    String updatedAt
) {
}
