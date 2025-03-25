package com.zipte.notifications.server.application.port.out.task;

public interface DeleteUserFavoritePort {

    void deleteByUserIdAndComplexCode(Long userId, String complexCode);

    void deleteByUserIdAndRegionCode(Long userId, String regionCode);

}
