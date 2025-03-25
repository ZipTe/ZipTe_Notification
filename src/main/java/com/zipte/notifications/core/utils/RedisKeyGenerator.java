package com.zipte.notifications.core.utils;

import static com.zipte.notifications.core.utils.CacheNames.NOTIFICATION;
import static com.zipte.notifications.core.utils.CacheNames.SEPARATOR;

public class RedisKeyGenerator {

    public static String getNotificationReadTime(Long userId) {

        return NOTIFICATION + SEPARATOR + userId;
    }


}
