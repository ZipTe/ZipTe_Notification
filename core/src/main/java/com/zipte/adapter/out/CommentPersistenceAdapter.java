package com.zipte.adapter.out;

import com.github.dockerjava.api.exception.NotFoundException;
import com.zipte.adapter.out.mongo.comment.CommentRepository;
import com.zipte.adapter.out.mongo.comment.CommentDocument;
import com.zipte.application.port.out.CommentNotificationPort;
import com.zipte.domain.CommentNotification;
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
                .toDomain(commentDocument);
    }

    @Override
    public Optional<CommentNotification> loadCommentNotification(Long commentId) {
        return commentMongoRepository.findByCommentId(commentId)
                .map(CommentDocument::toDomain);
    }

    @Override
    public void deleteCommentNotification(Long commentId) {
        CommentDocument document = commentMongoRepository.findByCommentId(commentId)
                .orElseThrow(() -> new NotFoundException("값이 존재하지않습니다"));

        commentMongoRepository.deleteById(document.getId());
    }
}
