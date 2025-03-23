package com.zipte.notifications.server.adapter.in.consumer;

import com.zipte.notifications.server.application.port.in.event.AddPropertyEventUseCase;
import com.zipte.notifications.server.application.port.in.event.RemovePropertyEventUseCase;
import com.zipte.notifications.server.domain.CommentEvent;
import com.zipte.notifications.server.domain.CommentEventType;
import com.zipte.notifications.server.domain.PropertyEvent;
import com.zipte.notifications.server.domain.PropertyEventType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class PropertyEventConsumer {

    private final AddPropertyEventUseCase addTask;
    private final RemovePropertyEventUseCase removeTask;

    @Bean("property")
    public Consumer<PropertyEvent> comment() {
        return event -> {
            if (event.getType() == PropertyEventType.ADD) {
                // 몽고디비에 저장하는 로직 수행
                addTask.processAddEvent(event);
            } else if (event.getType() == PropertyEventType.REMOVE) {
                // 몽고디비에서 지우는 로직 수행
                removeTask.processRemoveEvent(event);
            }
        };
    }



}
