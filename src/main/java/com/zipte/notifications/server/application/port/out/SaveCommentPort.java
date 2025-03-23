package com.zipte.notifications.server.application.port.out;

import com.zipte.notifications.server.domain.CommentNotification;

public interface SaveCommentPort {

    CommentNotification saveNotification(CommentNotification notification);


}
