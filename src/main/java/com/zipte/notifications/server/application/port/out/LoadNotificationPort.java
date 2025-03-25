package com.zipte.notifications.server.application.port.out;

import com.zipte.notifications.server.domain.CommentNotification;
import com.zipte.notifications.server.domain.Notification;
import com.zipte.notifications.server.domain.PropertyNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LoadNotificationPort {

    // 최신 알림 목록 조회
    Page<Notification> loadNotifications(Long userId, Pageable pageable);

    // 최신 알람의 시간
    Optional<Notification> loadNotificationsAt(Long userId);

    // 댓글 알림 상세 조회
    Optional<CommentNotification> loadCommentNotification(Long commentId);

    // 매물 알림 상세 조회
    Optional<PropertyNotification> loadPropertyNotification(String complexCode);


}
