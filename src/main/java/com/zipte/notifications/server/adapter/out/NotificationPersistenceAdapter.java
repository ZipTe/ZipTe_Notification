package com.zipte.notifications.server.adapter.out;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationDocument;
import com.zipte.notifications.server.adapter.out.mongo.base.NotificationRepository;
import com.zipte.notifications.server.adapter.out.mongo.comment.CommentDocument;
import com.zipte.notifications.server.adapter.out.mongo.comment.CommentDocumentRepository;
import com.zipte.notifications.server.adapter.out.mongo.property.PropertyDocument;
import com.zipte.notifications.server.adapter.out.mongo.property.PropertyDocumentRepository;
import com.zipte.notifications.server.application.port.out.LoadNotificationPort;
import com.zipte.notifications.server.domain.CommentNotification;
import com.zipte.notifications.server.domain.Notification;
import com.zipte.notifications.server.domain.PropertyNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NotificationPersistenceAdapter implements LoadNotificationPort {

    /*
        알림에 대한 정보를 가져온다.
     */

    private final NotificationRepository<NotificationDocument, String> repository;
    private final CommentDocumentRepository commentRepository;
    private final PropertyDocumentRepository propertyRepository;

    @Override
    public Page<Notification> loadNotifications(Long userId, Pageable pageable) {
        return repository.findAllByUserIdOrderByOccurredAtDesc(userId, pageable)
                .map(NotificationDocument::toDomain);
    }

    @Override
    public Optional<Notification> loadNotificationsAt(Long userId) {
        return propertyRepository.findFirstByUserIdOrderByOccurredAtDesc(userId)
                .map(NotificationDocument::toDomain);

    }

    @Override
    public Optional<CommentNotification> loadCommentNotification(Long commentId) {

        return commentRepository.findByCommentId(commentId)
                .map(CommentDocument::toDomain);
    }

    @Override
    public Optional<PropertyNotification> loadPropertyNotification(String complexCode) {
        return propertyRepository.findByComplexCode(complexCode)
                .map(PropertyDocument::toDomain);
    }


}
