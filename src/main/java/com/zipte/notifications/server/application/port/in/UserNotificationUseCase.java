package com.zipte.notifications.server.application.port.in;

import com.zipte.notifications.server.domain.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserNotificationUseCase {

    // 새로운 알림 여부
    boolean checkNewNotification(Long userId);

    // 알림 목록 가져오기
    Page<Notification> loadAllByUserId(Long userId, Pageable pageable);
}
