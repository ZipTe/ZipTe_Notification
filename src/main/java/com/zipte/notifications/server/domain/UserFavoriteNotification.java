package com.zipte.notifications.server.domain;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
public class UserFavoriteNotification extends Notification {

    private String complexCode;
    private String regionCode;

    // 생성자
    public static UserFavoriteNotification of(String id, NotificationType type, Long userId, Instant occurredAt, Instant createdAt, Instant lastUpdatedAt, Instant deleteAt, String complexCode, String regionCode) {

        return UserFavoriteNotification.builder()
                .id(id)
                .type(type)
                .userId(userId)
                .regionCode(regionCode)
                .occurredAt(occurredAt)
                .createdAt(createdAt)
                .lastUpdatedAt(lastUpdatedAt)
                .deleteAt(deleteAt)
                .complexCode(complexCode)
                .regionCode(regionCode)
                .build();
    }
}
