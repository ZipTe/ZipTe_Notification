package com.zipte.infrastructure.out.persistence.repository.mongo;

import com.zipte.domain.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoNotificationRepository extends MongoRepository<Notification,String> {

    Optional<Notification> findById(String id);

    Notification save(Notification notification);

    void deleteById(String id);

}
