package com.zipte.notifications.server.adapter.out.mongo.favorite;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationDocument;
import com.zipte.notifications.server.domain.UserFavoriteNotification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("user_favorite")
@Document("user_favorite")
public class UserFavoriteDocument extends NotificationDocument {

    private String complexCode;
    private String regionCode;

    // from
    public static UserFavoriteDocument from(UserFavoriteNotification notification) {
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
    public UserFavoriteNotification toDomain() {
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
