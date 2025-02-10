package com.zipte.application.port.in;

import com.zipte.domain.CommentNotification;

public interface CreateCommentNotificationUseCase {

    // 알림 정보 저장하기
    CommentNotification create(CommentNotification commentNotification);

}
