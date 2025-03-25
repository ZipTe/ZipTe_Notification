package com.zipte.notifications.server.application.port.out.task;

import com.zipte.notifications.server.domain.UserFavoriteNotification;

public interface SaveUserFavoritePort {

    UserFavoriteNotification saveUserFavorite(UserFavoriteNotification notification);
}
