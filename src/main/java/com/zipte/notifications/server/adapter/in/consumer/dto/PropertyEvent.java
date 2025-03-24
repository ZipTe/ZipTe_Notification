package com.zipte.notifications.server.adapter.in.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyEvent {

    /*
        Kafka로 받을 event 객체
        매물의 등록, 삭제 되었다는 행동 필요
        누가 올렸는지는 중요하지 않고, 가격이 변동만이 중요할 것 처럼 생각된다.
     */

    private PropertyEventType type;
    private String complexCode;
    private long price;
    private Instant occurredAt;

    //echo '{"type":"ADD","postId":1,"postOwnerId":1,"writerId":1,"commentId":1,"comment":"hello","occurredAt":"2025-02-10T23:50:00Z"}'| kafka-console-producer --broker-list localhost:9092 --topic comment
}