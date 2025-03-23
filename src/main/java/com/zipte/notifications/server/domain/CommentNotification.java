package com.zipte.notifications.server.domain;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
public class CommentNotification extends Notification {

    private Long postId;
    private Long writerId;
    private Long commentId;
    private String comment;

    /// 생성잔
    public static CommentNotification of(String id, Long userId, NotificationType type, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt, Long postId, Long writerId, Long commentId, String comment){
        return CommentNotification.builder()
                .id(id)
                .userId(userId)
                .type(type)
                .postId(postId)
                .writerId(writerId)
                .commentId(commentId)
                .comment(comment)
                .createdAt(createdAt)
                .occurredAt(occurredAt)
                .deleteAt(deleteAt)
                .lastUpdatedAt(lastUpdatedAt)
                .build();

    }

    /// 비즈니스 로직
}
