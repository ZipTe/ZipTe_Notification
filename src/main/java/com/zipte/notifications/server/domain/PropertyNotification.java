package com.zipte.notifications.server.domain;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
public class PropertyNotification extends Notification {

    private String complexCode;
    private long price;

    // 생성자
    public static PropertyNotification of(String id, NotificationType type,Long userId, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt, String complexCode, long price){
        return PropertyNotification.builder()
                .id(id)
                .type(type)
                .userId(userId)
                .complexCode(complexCode)
                .price(price)
                .occurredAt(occurredAt)
                .createdAt(createdAt)
                .lastUpdatedAt(lastUpdatedAt)
                .deleteAt(deleteAt)
                .build();
    }

}
