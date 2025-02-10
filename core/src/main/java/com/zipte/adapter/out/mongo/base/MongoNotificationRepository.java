package com.zipte.adapter.out.mongo.base;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoNotificationRepository extends MongoRepository<NotificationDocument,String> {

    Optional<NotificationDocument> findById(String id);

    NotificationDocument save(NotificationDocument notificationDocument);

    void deleteById(String id);

}
