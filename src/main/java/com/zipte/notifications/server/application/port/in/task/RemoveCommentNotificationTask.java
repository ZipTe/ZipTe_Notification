package com.zipte.notifications.server.application.port.in.task;


import com.zipte.notifications.server.adapter.out.kafka.event.CommentEvent;

public interface RemoveCommentNotificationTask {

    // 카프카에서 이벤트를 받은 상황
    void processRemoveEvent(CommentEvent commentEvent);

}
