package com.zipte.notifications.server.adapter.out.mongo.favorite;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationDocument;
import com.zipte.notifications.server.domain.Notification;
import com.zipte.notifications.server.domain.UserFavoriteNotification;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class UserFavoriteDocument extends NotificationDocument {

    private String complexCode;
    private String regionCode;

    // from
    public static UserFavoriteDocument of (UserFavoriteNotification notification) {
        return UserFavoriteDocument.builder()
                .id(notification.getId())
                .userId(notification.getUserId())
                .type(notification.getType())
                .occurredAt(notification.getOccurredAt())
                .createdAt(notification.getCreatedAt())
                .lastUpdatedAt(notification.getLastUpdatedAt())
                .deletedAt(notification.getDeleteAt())
                .complexCode(notification.getComplexCode())
                .regionCode(notification.getRegionCode())
                .build();
    }

    @Override
    public Notification toDomain() {
        return UserFavoriteNotification.builder()
                .id(getId())
                .userId(getUserId())
                .type(getType())
                .occurredAt(getOccurredAt())
                .createdAt(getCreatedAt())
                .lastUpdatedAt(getLastUpdatedAt())
                .deleteAt(getDeletedAt())
                .complexCode(getComplexCode())
                .regionCode(getRegionCode())
                .build();
    }
}
