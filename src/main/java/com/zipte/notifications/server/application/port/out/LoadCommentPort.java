package com.zipte.notifications.server.application.port.out;

import com.zipte.notifications.server.domain.CommentNotification;

import java.util.Optional;

public interface LoadCommentPort {

    Optional<CommentNotification> loadNotification(Long commentId);

}
