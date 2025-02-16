package com.zipte.application.port.in;

import com.zipte.domain.CommentNotification;

import java.util.Optional;

public interface GetCommentNotificationUseCase {

    // 알림 정보 가져오기
    Optional<CommentNotification> findByTypeAndCommentId(Long commentId);
}
