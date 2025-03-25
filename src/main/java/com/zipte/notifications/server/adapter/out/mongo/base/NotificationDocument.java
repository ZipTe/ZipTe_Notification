package com.zipte.notifications.server.adapter.out.mongo.base;

import com.zipte.notifications.server.domain.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document("notifications")
public abstract class NotificationDocument {

    @Field(targetType = FieldType.STRING)
    private String id;

    private Long userId;
    private NotificationType type;
    private Instant occurredAt;
    private Instant createdAt;
    private Instant lastUpdatedAt;
    private Instant deletedAt;

    public abstract Notification toDomain();
}
