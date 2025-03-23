package com.zipte.notifications.server.application.service;

import com.zipte.notifications.server.application.port.in.CommentNotificationUseCase;
import com.zipte.notifications.server.application.port.out.CommentNotificationPort;
import com.zipte.notifications.server.domain.CommentNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService implements CommentNotificationUseCase {

    private final CommentNotificationPort commentPort;

    @Override
    public CommentNotification create(CommentNotification commentNotification) {
        return commentPort.saveCommentNotification(commentNotification);
    }

    @Override
    public Optional<CommentNotification> findByTypeAndCommentId(Long commentId) {
        return commentPort.loadCommentNotification(commentId);
    }

}
