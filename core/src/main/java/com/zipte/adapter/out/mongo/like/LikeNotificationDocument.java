package com.zipte.adapter.out.mongo.like;

import com.zipte.adapter.out.mongo.base.NotificationDocument;
import com.zipte.adapter.out.mongo.base.NotificationType;
import lombok.Getter;
import org.springframework.data.annotation.TypeAlias;

import java.time.Instant;
import java.util.List;


@Getter
@TypeAlias("LikeNotification")
public class LikeNotificationDocument extends NotificationDocument {

    // 좋아요한 글 번호
    // 좋아요를 누른 사람 아이디가 리스트 형태로 들어간다.

    private final Long postId;
    private final List<Long> likerIds;

    public LikeNotificationDocument(String id, Long userId, NotificationType type, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt, Long postId, List<Long> likerIds) {
        super(id, userId, type, occurredAt, createdAt, lastUpdatedAt, deleteAt);
        this.postId = postId;
        this.likerIds = likerIds;
    }

}
