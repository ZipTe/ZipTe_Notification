package com.zipte.notifications.server.application.service.task;

import com.zipte.notifications.core.utils.NotificationIdGenerator;
import com.zipte.notifications.server.adapter.out.kafka.event.FavoriteType;
import com.zipte.notifications.server.adapter.out.kafka.event.UserFavoriteEvent;
import com.zipte.notifications.server.adapter.out.mongo.base.NotificationType;
import com.zipte.notifications.server.application.port.in.task.AddUserFavoriteNotificationTask;
import com.zipte.notifications.server.application.port.in.task.RemoveUserFavoriteNotificationTask;
import com.zipte.notifications.server.application.port.out.task.DeleteUserFavoritePort;
import com.zipte.notifications.server.application.port.out.task.SaveUserFavoritePort;
import com.zipte.notifications.server.domain.UserFavoriteNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@Transactional
@RequiredArgsConstructor
public class UserFavoriteNotificationService implements AddUserFavoriteNotificationTask, RemoveUserFavoriteNotificationTask {

    private final SaveUserFavoritePort savePort;
    private final DeleteUserFavoritePort deletePort;

    @Override
    public void processAddEvent(UserFavoriteEvent event) {
        Instant now = Instant.now();

        String complexCode = event.getFavoriteType().equals(FavoriteType.APARTMENT) ? event.getComplexCode() : null;
        String regionCode = event.getFavoriteType().equals(FavoriteType.REGION) ? event.getRegionCode() : null;

        UserFavoriteNotification notification = UserFavoriteNotification.of(
                NotificationIdGenerator.generate(),
                NotificationType.FAVORITE,
                event.getUserId(),
                event.getOccurredAt(),
                now,
                now,
                now.plus(90, ChronoUnit.DAYS),
                complexCode,
                regionCode
        );

        savePort.saveUserFavorite(notification);
    }



    @Override
    public void processRemoveEvent(UserFavoriteEvent event) {
        if (event.getFavoriteType().equals(FavoriteType.APARTMENT)) {
            deletePort.deleteByUserIdAndComplexCode(event.getUserId(), event.getComplexCode());
        } else if (event.getFavoriteType().equals(FavoriteType.REGION)) {
            deletePort.deleteByUserIdAndRegionCode(event.getUserId(), event.getRegionCode());
        }
    }


    // 생성

}
