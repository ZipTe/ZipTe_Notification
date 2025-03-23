package com.zipte.notifications.server.application.port.in;


import com.zipte.notifications.server.domain.CommentNotification;

import java.util.Optional;

public interface CommentNotificationUseCase {

    // 알림 정보 저장하기
    CommentNotification create(CommentNotification commentNotification);

    // 알림 정보 가져오기
    Optional<CommentNotification> findByTypeAndCommentId(Long commentId);
}
