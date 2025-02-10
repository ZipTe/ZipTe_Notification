package com.zipte.adapter.in.consumer;

import com.zipte.application.in.AddCommentEventUseCase;
import com.zipte.application.in.RemoveCommentEventUseCase;
import com.zipte.domain.CommentEvent;
import com.zipte.domain.CommentEventType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommentEventConsumer {

    private final AddCommentEventUseCase addTask;
    private final RemoveCommentEventUseCase removeTask;

    @Bean("comment")
    public Consumer<CommentEvent> comment() {
        return event -> {
            if (event.getType() == CommentEventType.ADD) {
                // 몽고디비에 저장하는 로직 수행
                addTask.processAddEvent(event);
            }
            else if (event.getType() == CommentEventType.REMOVE) {
                // 몽고디비에서 지우는 로직 수행
                removeTask.processRemoveEvent(event);
            }
        };
    }



}
