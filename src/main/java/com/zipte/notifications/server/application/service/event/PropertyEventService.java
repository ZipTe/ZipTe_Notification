package com.zipte.notifications.server.application.service.event;

import com.zipte.notifications.server.application.port.in.event.AddPropertyEventUseCase;
import com.zipte.notifications.server.application.port.in.event.RemovePropertyEventUseCase;
import com.zipte.notifications.server.application.port.out.DeletePropertyPort;
import com.zipte.notifications.server.application.port.out.LoadPropertyPort;
import com.zipte.notifications.server.application.port.out.SavePropertyPort;
import com.zipte.notifications.server.domain.PropertyEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

    /*
        Kafka로 받은 이벤트를 바탕으로 행동 구체화
     */

@Slf4j
@Component
@RequiredArgsConstructor
public class PropertyEventService implements AddPropertyEventUseCase, RemovePropertyEventUseCase {

    private final SavePropertyPort savePort;
    private final LoadPropertyPort loadPort;
    private final DeletePropertyPort deletePort;

    @Override
    public void processAddEvent(PropertyEvent event) {

    }

    @Override
    public void processRemoveEvent(PropertyEvent event) {

    }
}
