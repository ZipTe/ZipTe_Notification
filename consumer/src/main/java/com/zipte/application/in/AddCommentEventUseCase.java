package com.zipte.application.in;

import com.zipte.domain.CommentEvent;

public interface AddCommentEventUseCase {

    // 카프카에서 이벤트를 받은 상황
    void processAddEvent(CommentEvent commentEvent);

}
