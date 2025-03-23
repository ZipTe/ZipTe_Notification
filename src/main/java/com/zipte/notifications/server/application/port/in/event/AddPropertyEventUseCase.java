package com.zipte.notifications.server.application.port.in.event;


import com.zipte.notifications.server.domain.PropertyEvent;

public interface AddPropertyEventUseCase {

    // 카프카에서 이벤트를 받은 상황
    void processAddEvent(PropertyEvent event);

}
