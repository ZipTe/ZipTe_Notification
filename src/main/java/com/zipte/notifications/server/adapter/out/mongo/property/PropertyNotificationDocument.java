package com.zipte.notifications.server.adapter.out.mongo.property;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationDocument;
import com.zipte.notifications.server.domain.PropertyNotification;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

@Getter
@TypeAlias("PropertyNotification")
@SuperBuilder
public class PropertyNotificationDocument extends NotificationDocument {

    private Long complexCode;
    private int price;

    // From
    public static PropertyNotificationDocument from(PropertyNotification notification) {
        return PropertyNotificationDocument.builder()
                .id(notification.getId())
                .userId(notification.getUserId())
                .type(notification.getType())
                .occurredAt(notification.getOccurredAt())
                .createdAt(notification.getCreatedAt())
                .lastUpdatedAt(notification.getLastUpdatedAt())
                .deleteAt(notification.getDeleteAt())
                .complexCode(notification.getComplexCode())
                .price(notification.getPrice())
                .build();
    }

    // toDomain
    public PropertyNotification toDomain() {
        return PropertyNotification.builder()
                .id(this.id)
                .userId(this.userId)
                .type(this.type)
                .occurredAt(this.occurredAt)
                .createdAt(this.createdAt)
                .lastUpdatedAt(this.lastUpdatedAt)
                .deleteAt(this.deleteAt)
                .complexCode(this.complexCode)
                .price(this.price)
                .build();
    }
}
