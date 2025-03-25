package com.zipte.notifications.server.application.port.in.task;


import com.zipte.notifications.server.adapter.out.kafka.event.PropertyEvent;

public interface RemovePropertyNotificationTask {

    // 카프카에서 이벤트를 받은 상황
    void processRemoveEvent(PropertyEvent event);

}
