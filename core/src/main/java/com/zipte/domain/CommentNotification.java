package com.zipte.domain;

import com.zipte.adapter.out.mongo.base.NotificationType;
import lombok.Getter;

import java.time.Instant;

@Getter
public class CommentNotification extends Notification {

    private Long postId;
    private Long writerId;
    private Long commentId;
    private String comment;

    public CommentNotification(String id, Long userId, NotificationType type, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt, Long postId, Long writerId, Long commentId, String comment) {
        super(id, userId, type, occurredAt, lastUpdatedAt, createdAt, deleteAt);
        this.postId = postId;
        this.writerId = writerId;
        this.commentId = commentId;
        this.comment = comment;
    }
}
