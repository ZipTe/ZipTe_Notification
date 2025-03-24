package com.zipte.notifications.server.adapter.out.mongo.property;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationRepository;

import java.util.Optional;

public interface PropertyDocumentRepository extends NotificationRepository<PropertyDocument, String> {

    Optional<PropertyDocument> findByComplexCode(String complexCode);

    void deleteByComplexCode(String complexCode);

}
