package com.zipte.notifications.server.adapter.in.consumer;

import com.zipte.notifications.server.application.port.in.task.AddPropertyNotificationTask;
import com.zipte.notifications.server.application.port.in.task.RemovePropertyNotificationTask;
import com.zipte.notifications.server.adapter.in.consumer.dto.PropertyEvent;
import com.zipte.notifications.server.adapter.in.consumer.dto.EventType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class PropertyEventConsumer {

    private final AddPropertyNotificationTask addTask;
    private final RemovePropertyNotificationTask removeTask;

    @Bean("property")
    public Consumer<PropertyEvent> property() {
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
