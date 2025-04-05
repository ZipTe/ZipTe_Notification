package com.zipte.notifications.server.adapter.out.mongo.property;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationDocument;
import com.zipte.notifications.server.domain.PropertyNotification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

@Getter
@TypeAlias("Property_notification")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PropertyDocument extends NotificationDocument {

    private String complexCode;
    private long price;

    // From
    public static PropertyDocument from(PropertyNotification notification) {
        return PropertyDocument.builder()
                .id(notification.getId())
                .userId(notification.getUserId())
                .complexCode(notification.getComplexCode())
                .price(notification.getPrice())
                .type(notification.getType())
                .occurredAt(notification.getOccurredAt())
                .createdAt(notification.getCreatedAt())
                .lastUpdatedAt(notification.getLastUpdatedAt())
                .deletedAt(notification.getDeleteAt())
                .build();
    }

    // toDomain
    public PropertyNotification toDomain() {
        return PropertyNotification.builder()
                .id(getId())
                .userId(getUserId())
                .type(getType())
                .deleteAt(getDeletedAt())
                .complexCode(complexCode)
                .price(price)
                .occurredAt(getOccurredAt())
                .createdAt(getCreatedAt())
                .lastUpdatedAt(getLastUpdatedAt())
                .build();
    }
}
