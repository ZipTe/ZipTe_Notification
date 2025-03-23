package com.zipte.notifications.server.adapter.out;

import com.zipte.notifications.server.adapter.out.mongo.comment.CommentDocument;
import com.zipte.notifications.server.adapter.out.mongo.comment.CommentRepository;
import com.zipte.notifications.server.application.port.out.CommentNotificationPort;
import com.zipte.notifications.server.domain.CommentNotification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class CommentPersistenceAdapter implements CommentNotificationPort {

    private final CommentRepository commentMongoRepository;

    @Override
    public CommentNotification saveCommentNotification(CommentNotification comment) {
        var commentDocument = CommentDocument.from(comment);

        return commentMongoRepository.save(commentDocument)
                .toDomain();
    }

    @Override
    public Optional<CommentNotification> loadCommentNotification(Long commentId) {
        return commentMongoRepository.findByCommentId(commentId)
                .map(CommentDocument::toDomain);
    }

    @Override
    public void deleteCommentNotification(Long commentId) {
        CommentDocument document = commentMongoRepository.findByCommentId(commentId)
                .orElseThrow(() -> new EntityNotFoundException("값이 존재하지않습니다"));

        commentMongoRepository.deleteById(document.getId());
    }
}
