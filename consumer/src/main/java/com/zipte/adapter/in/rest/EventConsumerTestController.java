package com.zipte.adapter.in.rest;

import com.zipte.domain.CommentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@Slf4j
@RestController
public class EventConsumerTestController{

    @Autowired
    private Consumer<CommentEvent> comment;

    @PostMapping("/test/comment")
    public String comment(@RequestBody CommentEvent event) {
        comment.accept(event);
        return "success";
    }


}
