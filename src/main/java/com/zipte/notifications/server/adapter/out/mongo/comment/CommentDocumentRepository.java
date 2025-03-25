package com.zipte.notifications.server.adapter.out.mongo.comment;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationRepository;

import java.util.Optional;

public interface CommentDocumentRepository extends NotificationRepository<CommentDocument, String> {


    Optional<CommentDocument> findByCommentId(Long commentId);

}
