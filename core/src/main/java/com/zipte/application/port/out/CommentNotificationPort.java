package com.zipte.application.port.out;


import com.zipte.domain.CommentNotification;

import java.util.Optional;

public interface CommentNotificationPort {

    /*
        도메인 객체를 외부의 연결체에서 저장해주는 Port의 역할을 수행한다.
     */

    CommentNotification saveCommentNotification(CommentNotification commentNotification);

    Optional<CommentNotification> loadCommentNotification(Long commentId);

    void deleteCommentNotification(Long commentId);



}
