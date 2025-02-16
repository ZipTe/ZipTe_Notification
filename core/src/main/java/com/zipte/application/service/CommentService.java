package com.zipte.application.service;

import com.zipte.adapter.out.mongo.base.NotificationType;
import com.zipte.application.port.in.CreateCommentNotificationUseCase;
import com.zipte.application.port.in.GetCommentNotificationUseCase;
import com.zipte.application.port.out.CommentNotificationPort;
import com.zipte.domain.CommentNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService implements CreateCommentNotificationUseCase, GetCommentNotificationUseCase {

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
