package com.zipte.notifications.server.application.service.task;

import com.zipte.notifications.core.utils.NotificationIdGenerator;
import com.zipte.notifications.server.adapter.out.mongo.base.NotificationType;
import com.zipte.notifications.server.application.port.in.task.AddCommentNotificationTask;
import com.zipte.notifications.server.application.port.in.task.RemoveCommentNotificationTask;
import com.zipte.notifications.server.application.port.out.task.DeleteCommentPort;
import com.zipte.notifications.server.application.port.out.task.SaveCommentPort;
import com.zipte.notifications.server.adapter.in.consumer.dto.CommentEvent;
import com.zipte.notifications.server.domain.CommentNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

    /*
        Kafka로 받은 이벤트를 바탕으로 행동 구체화
        -> mongoDB 저장
     */

@Service
@Transactional
@RequiredArgsConstructor
public class CommentNotificationService implements AddCommentNotificationTask, RemoveCommentNotificationTask {

    private final SaveCommentPort savePort;
    private final DeleteCommentPort deletePort;

    public void processAddEvent(CommentEvent event) {

        Instant now = Instant.now();

        // 글 작성자와 같다면 알림은 스킵
        if (Objects.equals(event.getPostOwnerId(), event.getWriterId())) {
            return; // 글 작성자와 댓글 작성자가 같으면 알림 X
        }

        CommentNotification notification = createNotification(event, now);

        // DB에 저장
        savePort.saveNotification(notification);

    }

    @Override
    public void processRemoveEvent(CommentEvent commentEvent) {
        deletePort.deleteCommentNotification(commentEvent.getCommentId());
    }

    private CommentNotification createNotification(CommentEvent event, Instant now) {
        // 알림 생성
        return CommentNotification.of
                (NotificationIdGenerator.generate(),
                        event.getPostOwnerId(),
                        NotificationType.COMMENT,
                        event.getOccurredAt(),
                        now,
                        now,
                        now.plus(90, ChronoUnit.DAYS),
                        event.getPostId(),
                        event.getWriterId(),
                        event.getCommentId(),
                        event.getComment());
    }


}
