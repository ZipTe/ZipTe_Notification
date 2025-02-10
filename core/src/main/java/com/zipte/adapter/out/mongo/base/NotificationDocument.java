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
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    public static NotificationDocument of(String id, Long userId, NotificationType type, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt) {

        return NotificationDocument.builder()
                .id(id)
                .userId(userId)
                .type(type)
                .occurredAt(occurredAt)
                .createdAt(createdAt)
                .lastUpdatedAt(lastUpdatedAt)
                .deleteAt(deleteAt).build();
    }





}
