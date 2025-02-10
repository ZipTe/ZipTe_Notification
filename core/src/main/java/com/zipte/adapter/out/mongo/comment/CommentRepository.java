package com.zipte.adapter.out.mongo.comment;

import com.zipte.adapter.out.mongo.base.NotificationType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<CommentDocument,String> {

    CommentDocument save(CommentDocument notification);

    Optional<CommentDocument> findById(String id);

    void deleteById(String id);

    @Query("{'commentId': ?0 }")
    Optional<CommentDocument> findByCommentId(Long commentId);

}
