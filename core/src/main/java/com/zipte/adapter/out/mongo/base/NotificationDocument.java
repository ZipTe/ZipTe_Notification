package com.zipte.adapter.out.mongo.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;

@Document("notifications")
@Getter
public abstract class NotificationDocument {

    @Field(targetType = FieldType.STRING)
    public String id;
    public Long userId;
    public NotificationType type;
    public Instant occurredAt;
    public Instant createdAt;
    public Instant lastUpdatedAt;
    public Instant deleteAt;

    // 생성자
    public NotificationDocument(String id, Long userId, NotificationType type,Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.occurredAt = occurredAt;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.deleteAt = deleteAt;
    }







}
