package com.zipte.domain;

import lombok.Getter;
import org.springframework.data.annotation.TypeAlias;

import java.time.Instant;
import java.util.List;


@Getter
@TypeAlias("LikeNotification")
public class LikeNotification extends Notification {

    // 좋아요한 글 번호
    // 좋아요를 누른 사람 아이디가 리스트 형태로 들어간다.

    private final Long postId;
    private final List<Long> likerIds;

    public LikeNotification(String id, Long userId, NotificationType type, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt, Long postId, List<Long> likerIds) {
        super(id, userId, type, occurredAt, createdAt, lastUpdatedAt, deleteAt);
        this.postId = postId;
        this.likerIds = likerIds;
    }

    public void addLiker(Long likerId,Instant occurredAt ,Instant now, Instant retention) {
        likerIds.add(likerId);
        this.setOccurredAt(occurredAt);
        this.setLastUpdatedAt(now);
        this.setDeleteAt(retention);
    }

    public void removeLiker(Long likerId, Instant now) {
        likerIds.remove(likerId);
        this.setLastUpdatedAt(now);
    }
}
