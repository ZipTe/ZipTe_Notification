package com.zipte.notifications.server.application.port.out;

import com.zipte.notifications.server.domain.PropertyNotification;

public interface SavePropertyPort {

    PropertyNotification saveNotification(PropertyNotification notification);


}
