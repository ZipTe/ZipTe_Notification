package com.zipte.application.service;

import com.zipte.adapter.out.mongo.base.NotificationType;
import com.zipte.application.in.AddCommentEventUseCase;
import com.zipte.application.in.RemoveCommentEventUseCase;
import com.zipte.application.port.in.CreateCommentNotificationUseCase;
import com.zipte.domain.CommentNotification;
import com.zipte.domain.CommentEvent;
import com.zipte.utils.NotificationIdGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

    /*
        Kafka로 받은 이벤트를 바탕으로 행동 구체화
     */

@Slf4j
@Component
@RequiredArgsConstructor
public class CommentEventService implements AddCommentEventUseCase, RemoveCommentEventUseCase {

    private final CreateCommentNotificationUseCase saveUseCase;

    public void processAddEvent(CommentEvent commentEvent) {

        // 글 작성자와 같다면 알림은 스킵
        if (Objects.equals(commentEvent.getPostOwnerId(), commentEvent.getWriterId())) {
            return; // 글 작성자와 댓글 작성자가 같으면 알림 X
        }

        // 알림 생성
        CommentNotification notification = createNotification(commentEvent);

        // 저장
        saveUseCase.create(notification);

    }

    private CommentNotification createNotification(CommentEvent event) {
        Instant now = Instant.now();

        return new CommentNotification(
                NotificationIdGenerator.generate(),
                event.getPostOwnerId(), // ✅ 글 작성자가 알림을 받음
                NotificationType.COMMENT,
                event.getOccurredAt(),
                now,
                now,
                now.plus(90, ChronoUnit.DAYS),
                event.getPostId(),
                event.getWriterId(),
                event.getCommentId(),
                event.getComment()
        );
    }


    @Override
    public void processRemoveEvent(CommentEvent commentEvent) {

    }
}
