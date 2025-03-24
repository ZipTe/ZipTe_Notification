package com.zipte.notifications.server.adapter.out.mongo.base;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface NotificationRepository <T extends NotificationDocument, ID>  extends MongoRepository<T, ID> {

    // 목록조회하기 (처음부터)
    Slice<NotificationDocument> findAllByUserIdOrderByOccurredAtDesc(long userId, Pageable pageable);

    // occurredAt이 있으면, 해당 pivot부터 조회
    Slice<NotificationDocument> findAllByUserIdAndOccurredAtLessThanOrderByOccurredAtDesc(long userId, Instant pivot, Pageable pageable);

    // 최신 읽음 시간 1개 가져오기
    Optional<NotificationDocument> findFirstByUserIdOrderByOccurredAtDesc(Long userId);

}
