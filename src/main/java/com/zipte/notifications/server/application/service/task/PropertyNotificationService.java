package com.zipte.notifications.server.application.service.task;

import com.zipte.notifications.core.utils.NotificationIdGenerator;
import com.zipte.notifications.server.adapter.out.mongo.base.NotificationType;
import com.zipte.notifications.server.application.port.in.task.AddPropertyNotificationTask;
import com.zipte.notifications.server.application.port.in.task.RemovePropertyNotificationTask;
import com.zipte.notifications.server.application.port.out.task.DeletePropertyPort;
import com.zipte.notifications.server.application.port.out.task.SavePropertyPort;
import com.zipte.notifications.server.adapter.in.consumer.dto.PropertyEvent;
import com.zipte.notifications.server.domain.PropertyNotification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

    /*
        Kafka로 받은 이벤트를 바탕으로 행동 구체화
     */

@Slf4j
@Component
@RequiredArgsConstructor
public class PropertyNotificationService implements AddPropertyNotificationTask, RemovePropertyNotificationTask {

    private final SavePropertyPort savePort;
    private final DeletePropertyPort deletePort;

    @Override
    public void processAddEvent(PropertyEvent event) {

        Instant now = Instant.now();

        PropertyNotification notification = createNotification(event, now);

        // DB에 저장
        log.info("Processing event {}", notification);
        savePort.saveNotification(notification);

    }

    @Override
    public void processRemoveEvent(PropertyEvent event) {
        deletePort.deleteCommentNotification(event.getComplexCode());
    }

    private PropertyNotification createNotification(PropertyEvent event, Instant now) {
        // 알림 생성
        return PropertyNotification.of
                (NotificationIdGenerator.generate(),
                        NotificationType.PROPERTY,
                        null,
                        event.getOccurredAt(),
                        now,
                        now,
                        now.plus(90, ChronoUnit.DAYS),
                        event.getComplexCode(),
                        event.getPrice());
    }

}