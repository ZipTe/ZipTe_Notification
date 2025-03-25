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
public class UserFavoriteEvent {

    /*
        Kafka로 받을 event 객체
        유저의 관심목록에 대한 정보를 추가한다.
        매물의 등록, 삭제 되었다는 행동 필요
     */

    private EventType type;
    private Long userId;
    private String complexCode;
    private String regionCode;
    private Instant occurredAt;

}