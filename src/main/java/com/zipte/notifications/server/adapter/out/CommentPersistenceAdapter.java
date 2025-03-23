package com.zipte.notifications.server.adapter.out;

import com.zipte.notifications.server.adapter.out.mongo.comment.CommentDocument;
import com.zipte.notifications.server.adapter.out.mongo.comment.CommentDocumentRepository;
import com.zipte.notifications.server.application.port.out.DeleteCommentPort;
import com.zipte.notifications.server.application.port.out.LoadCommentPort;
import com.zipte.notifications.server.application.port.out.SaveCommentPort;
import com.zipte.notifications.server.domain.CommentNotification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class CommentPersistenceAdapter implements SaveCommentPort, LoadCommentPort, DeleteCommentPort {


    private final CommentDocumentRepository commentMongoRepository;

    @Override
    public CommentNotification saveNotification(CommentNotification comment) {
        var commentDocument = CommentDocument.from(comment);

        return commentMongoRepository.save(commentDocument)
                .toDomain();
    }

    @Override
    public Optional<CommentNotification> loadNotification(Long commentId) {
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
