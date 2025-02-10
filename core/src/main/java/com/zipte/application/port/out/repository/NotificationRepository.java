package com.zipte.application.port.out.repository;

import com.zipte.domain.Notification;

import java.util.Optional;

public interface NotificationRepository {

    Notification save(Notification notification);
    Optional<Notification> findById(String id);
    void deleteById(String id);

}
