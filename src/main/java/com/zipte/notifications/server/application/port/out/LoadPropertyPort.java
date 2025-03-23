package com.zipte.notifications.server.application.port.out;

import com.zipte.notifications.server.domain.PropertyNotification;

import java.util.Optional;

public interface LoadPropertyPort {

    Optional<PropertyNotification> loadNotification(String complexCode);

}
