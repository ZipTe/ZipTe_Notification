package com.zipte.notifications.server.application.port.in.event;


import com.zipte.notifications.server.domain.CommentEvent;

public interface RemoveCommentEventUseCase {

    // 카프카에서 이벤트를 받은 상황
    void processRemoveEvent(CommentEvent commentEvent);

}
