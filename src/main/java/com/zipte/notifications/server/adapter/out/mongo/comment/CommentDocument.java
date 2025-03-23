package com.zipte.notifications.server.adapter.out.mongo.comment;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationDocument;
import com.zipte.notifications.server.domain.CommentNotification;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "comment_notifications")
@SuperBuilder
public class CommentDocument extends NotificationDocument {

    private final Long postId;
    private final Long writerId;
    private final Long commentId;
    private final String comment;

    // from
    public static CommentDocument from(CommentNotification notification) {
        return CommentDocument.builder()
                .id(notification.getId())
                .userId(notification.getUserId())
                .type(notification.getType())
                .occurredAt(notification.getOccurredAt())
                .createdAt(notification.getCreatedAt())
                .lastUpdatedAt(notification.getLastUpdatedAt())
                .deleteAt(notification.getDeleteAt())
                .postId(notification.getPostId())
                .writerId(notification.getWriterId())
                .commentId(notification.getCommentId())
                .comment(notification.getComment())
                .build();
    }

    // toDomain
    public CommentNotification toDomain() {
        return CommentNotification.builder()
                .id(this.id)
                .userId(this.userId)
                .type(this.type)
                .occurredAt(this.occurredAt)
                .createdAt(this.createdAt)
                .lastUpdatedAt(this.lastUpdatedAt)
                .deleteAt(this.deleteAt)
                .postId(this.postId)
                .writerId(this.writerId)
                .commentId(this.commentId)
                .comment(this.comment)
                .build();
    }
}
