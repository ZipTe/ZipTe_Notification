package com.zipte.notifications.server.adapter.out;

import com.zipte.notifications.core.utils.RedisKeyGenerator;
import com.zipte.notifications.server.application.port.out.ReadNotificationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class NotificationRedisPersistenceAdapter implements ReadNotificationPort {

    /*
        90일동안, 유저의 읽은 시간을 기록하는 구조입니다.
     */

    private final RedisTemplate<String, Long> redisTemplate;

    @Override
    public void setLatestReadAt(Long userId) {
        String key = RedisKeyGenerator.getNotificationReadTime(userId);
        redisTemplate.opsForValue().set(key, Instant.now().toEpochMilli());
        redisTemplate.expire(key, 7, TimeUnit.DAYS); // TTL 30일 설정
    }

    @Override
    public Instant getLatestReadAt(Long userId) {
        String key = RedisKeyGenerator.getNotificationReadTime(userId);
        Long lastReadAt = redisTemplate.opsForValue().get(key);

        if (lastReadAt == null) {
            return null;
        }

        return Instant.ofEpochMilli(lastReadAt);
    }
}
