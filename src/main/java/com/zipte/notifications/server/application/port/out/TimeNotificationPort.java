package com.zipte.notifications.server.application.port.out;

import java.time.Instant;

public interface TimeNotificationPort {

    // 현재시간으로 읽음처리
    void setLatestReadAt(Long userId);

    // 캐시에서 나의 읽음시간 가져오기
    Instant getLatestReadAt(Long userId);
}
