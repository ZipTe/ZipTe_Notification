package com.zipte.notifications.server.adapter.out.mongo.base;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;

@Getter
@SuperBuilder
@Document("notifications")
public abstract class NotificationDocument {

    @Field(targetType = FieldType.STRING)
    public String id;
    public Long userId;
    public NotificationType type;
    public Instant occurredAt;
    public Instant createdAt;
    public Instant lastUpdatedAt;
    public Instant deletedAt;
}
