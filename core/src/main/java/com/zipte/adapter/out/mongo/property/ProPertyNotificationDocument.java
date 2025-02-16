package com.zipte.adapter.out.mongo.property;

import com.zipte.adapter.out.mongo.base.NotificationDocument;
import com.zipte.adapter.out.mongo.base.NotificationType;
import lombok.Getter;
import org.springframework.data.annotation.TypeAlias;

import java.time.Instant;


@Getter
@TypeAlias("PropertyNotification")
public class ProPertyNotificationDocument extends NotificationDocument {


    public ProPertyNotificationDocument(String id, Long userId, NotificationType type, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt) {
        super(id, userId, type, occurredAt, createdAt, lastUpdatedAt, deleteAt);
    }
}
