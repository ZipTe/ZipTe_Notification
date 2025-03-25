package com.zipte.notifications.server.application.service.task;

import com.zipte.notifications.core.utils.NotificationIdGenerator;
import com.zipte.notifications.server.adapter.out.mongo.base.NotificationType;
import com.zipte.notifications.server.application.port.in.task.AddPropertyNotificationTask;
import com.zipte.notifications.server.application.port.in.task.RemovePropertyNotificationTask;
import com.zipte.notifications.server.application.port.out.task.DeletePropertyPort;
import com.zipte.notifications.server.application.port.out.task.LoadUserFavoritePort;
import com.zipte.notifications.server.application.port.out.task.SavePropertyPort;
import com.zipte.notifications.server.adapter.out.kafka.event.PropertyEvent;
import com.zipte.notifications.server.domain.PropertyNotification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class PropertyNotificationService implements AddPropertyNotificationTask, RemovePropertyNotificationTask {

    private final SavePropertyPort savePort;
    private final DeletePropertyPort deletePort;

    // 의존성
    private final LoadUserFavoritePort loadUserFavoritePort;

    @Override
    public void processAddEvent(PropertyEvent event) {

        Instant now = Instant.now();

        // 모든 알림이 동일하게 생성
        List<Long> favoriteUsers = loadUserFavoritePort.loadUserFavoriteByComplexCode(event.getComplexCode());

        favoriteUsers.forEach(userId -> {
            PropertyNotification notification = createNotification(event, now, userId);
            savePort.saveNotification(notification);
        });
    }

    @Override
    public void processRemoveEvent(PropertyEvent event) {
        deletePort.deleteCommentNotification(event.getComplexCode());
    }

    private PropertyNotification createNotification(PropertyEvent event, Instant now, Long userId) {

        return PropertyNotification.of(
                NotificationIdGenerator.generate(),
                NotificationType.PROPERTY,
                userId,
                event.getOccurredAt(),
                now,
                now,
                now.plus(90, ChronoUnit.DAYS),
                event.getComplexCode(),
                event.getPrice());
    }

}