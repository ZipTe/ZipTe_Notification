package com.zipte.application.port.out;


import com.zipte.domain.CommentNotification;

import java.util.Optional;

public interface CommentNotificationPort {

    CommentNotification saveCommentNotification(CommentNotification comment);

    void deleteCommentNotification(String commentId);

    Optional<CommentNotification> loadCommentNotification(String commentId);
}
