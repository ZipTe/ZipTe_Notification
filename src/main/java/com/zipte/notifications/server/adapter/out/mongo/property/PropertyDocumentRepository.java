package com.zipte.notifications.server.adapter.out.mongo.property;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationDocument;
import com.zipte.notifications.server.adapter.out.mongo.base.NotificationRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PropertyDocumentRepository extends NotificationRepository<PropertyDocument, String> {


    void deleteByComplexCode(String complexCode);

    Optional<NotificationDocument> findFirstByUserIdOrderByOccurredAtDesc(Long userId);

    @Query("{'complexCode' : ?0}")
    Optional<PropertyDocument> findByComplexCode(String complexCode);


}
