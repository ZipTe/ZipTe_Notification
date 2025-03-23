package com.zipte.notifications.server.adapter.in.web;

import com.zipte.notifications.server.domain.CommentEvent;
import com.zipte.notifications.server.domain.PropertyEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EventConsumerTestController {

    private final Consumer<CommentEvent> comment;
    private final Consumer<PropertyEvent> property;

    @PostMapping("/test/comment")
    public void comment(@RequestBody CommentEvent event) {
        comment.accept(event);
    }

    @PostMapping("/test/property")
    public void property(@RequestBody PropertyEvent event) {
        property.accept(event);
    }

}
