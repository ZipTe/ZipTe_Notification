package com.zipte.notifications.server.application.port.in.task;


import com.zipte.notifications.server.adapter.in.consumer.dto.CommentEvent;

public interface AddCommentNotificationTask {

    // 카프카에서 이벤트를 받은 상황
    void processAddEvent(CommentEvent commentEvent);

}
