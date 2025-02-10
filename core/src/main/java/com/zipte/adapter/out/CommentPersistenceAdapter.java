package com.zipte.adapter.out;

import com.zipte.adapter.out.mongo.base.MongoNotificationRepository;
import com.zipte.adapter.out.mongo.comment.CommentNotificationDocument;
import com.zipte.application.port.out.CommentNotificationPort;
import com.zipte.domain.CommentNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class CommentPersistenceAdapter implements CommentNotificationPort {

    private final MongoNotificationRepository commentMongoRepository;

    @Override
    public CommentNotification saveCommentNotification(CommentNotification comment) {
        var commentDocument = CommentNotificationDocument.from(comment);

        return commentMongoRepository.save(commentDocument)
                .toDomain();
    }

    @Override
    public void deleteCommentNotification(String commentId) {

    }

    @Override
    public Optional<CommentNotification> loadCommentNotification(String commentId) {
        return Optional.empty();
    }
}
