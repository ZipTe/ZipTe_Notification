package com.zipte.notifications.server.application.port.in;


import com.zipte.notifications.server.domain.CommentEvent;

public interface AddCommentEventUseCase {

    // 카프카에서 이벤트를 받은 상황
    void processAddEvent(CommentEvent commentEvent);

}
