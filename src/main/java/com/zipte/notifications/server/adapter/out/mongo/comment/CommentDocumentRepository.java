package com.zipte.notifications.server.adapter.out.mongo.comment;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CommentDocumentRepository extends MongoRepository<CommentDocument,String> {


    Optional<CommentDocument> findByCommentId(Long commentId);

}
