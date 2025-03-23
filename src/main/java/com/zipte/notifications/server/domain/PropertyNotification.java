package com.zipte.notifications.server.domain;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
public class PropertyNotification extends Notification {

    private String id;
    private final Long complexCode;
    private final int price;

    // 생성자
    public static PropertyNotification of(String id, Long userId, NotificationType type, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt, Long complexCode, int price){
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
