package com.zipte.adapter.out.mongo.comment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<CommentDocument,String> {

    CommentDocument save(CommentDocument notification);

    Optional<CommentDocument> findById(String id);

    void deleteById(String id);

    Optional<CommentDocument> findByCommentId(Long commentId);

}
