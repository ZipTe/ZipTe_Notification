package com.zipte.adapter.out.mongo.base;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoNotificationRepository<T extends NotificationDocument> extends MongoRepository<T, String> {

    Optional<T> findById(String id);

    T save(T notificationDocument);

    void deleteById(String id);

}
