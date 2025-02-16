package com.zipte.domain;

import com.zipte.adapter.out.mongo.base.NotificationType;
import lombok.Getter;

import java.time.Instant;

@Getter
public class Notification {

    public String id;
    public Long userId;
    public NotificationType type;
    public Instant occurredAt;
    public Instant createdAt;
    public Instant lastUpdatedAt;
    public Instant deleteAt;

    // 생성자
    public Notification(String id, Long userId, NotificationType type, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.occurredAt = occurredAt;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.deleteAt = deleteAt;
    }

    public void setOccurredAt(Instant occurredAt) {
        this.occurredAt = occurredAt;
    }

    public void setLastUpdatedAt(Instant lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public void setDeleteAt(Instant deleteAt) {
        this.deleteAt = deleteAt;
    }

}
