package com.zipte.adapter.out.mongo.comment;

import com.zipte.adapter.out.mongo.base.NotificationDocument;
import com.zipte.adapter.out.mongo.base.NotificationType;
import com.zipte.domain.CommentNotification;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Document(collection = "comment_notifications")
public class CommentDocument extends NotificationDocument {

    private final Long postId;
    private final Long writerId;
    private final Long commentId;
    private final String comment;

    public CommentDocument(String id, Long userId, NotificationType type, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt, Long postId, Long writerId, Long commentId, String comment) {
        super(id, userId, type, occurredAt, lastUpdatedAt, createdAt, deleteAt);
        this.postId = postId;
        this.writerId = writerId;
        this.commentId = commentId;
        this.comment = comment;
    }

    public static CommentDocument from(CommentNotification commentNotification) {
        return new CommentDocument(
                commentNotification.getId(),
                commentNotification.getUserId(),
                commentNotification.getType(),
                commentNotification.getOccurredAt(),
                commentNotification.getCreatedAt(),
                commentNotification.getLastUpdatedAt(),
                commentNotification.getDeleteAt(),
                commentNotification.getPostId(),
                commentNotification.getWriterId(),
                commentNotification.getCommentId(),
                commentNotification.getComment()
        );
    }

    public static CommentNotification toDomain(CommentDocument document){
        return new CommentNotification(
                document.getId(),
                document.getUserId(),
                document.getType(),
                document.getOccurredAt(),
                document.getCreatedAt(),
                document.getLastUpdatedAt(),
                document.getDeleteAt(),
                document.getPostId(),
                document.getWriterId(),
                document.getCommentId(),
                document.getComment());
    }

}
