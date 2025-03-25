package com.zipte.notifications.server.adapter.in.consumer;

import com.zipte.notifications.server.adapter.out.kafka.event.EventType;
import com.zipte.notifications.server.adapter.out.kafka.event.UserFavoriteEvent;
import com.zipte.notifications.server.application.port.in.task.AddUserFavoriteNotificationTask;
import com.zipte.notifications.server.application.port.in.task.RemoveUserFavoriteNotificationTask;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserFavoriteConsumer {

    private final AddUserFavoriteNotificationTask addTask;
    private final RemoveUserFavoriteNotificationTask removeTask;

    @Bean("favorite")
    public Consumer<UserFavoriteEvent> favorite() {
        return event -> {
            if (event.getType() == EventType.ADD) {
                // 몽고디비에 저장하는 로직 수행
                addTask.processAddEvent(event);
            } else if (event.getType() == EventType.REMOVE) {
                // 몽고디비에서 지우는 로직 수행
                removeTask.processRemoveEvent(event);
            }
        };
    }



}
