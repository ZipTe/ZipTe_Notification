package com.zipte.notifications.server.adapter.in.web;

import com.zipte.notifications.core.response.ApiResponse;
import com.zipte.notifications.core.response.pageable.PageRequest;
import com.zipte.notifications.core.response.pageable.PageResponse;
import com.zipte.notifications.server.application.port.in.UserNotificationUseCase;
import com.zipte.notifications.server.domain.Notification;
import com.zipte.notifications.server.domain.PropertyNotification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final UserNotificationUseCase notificationService;

    @GetMapping("/{userId}")
    public ApiResponse<String> get(@PathVariable Long userId) {

        boolean checked = notificationService.checkNewNotification(userId);
        if (checked) {
            return ApiResponse.ok("새로운 알림이 존재합니다.");
        } else {
            return ApiResponse.ok("새로운 알림이 존재하지 않습니다.");
        }
    }

    @GetMapping("/list/{userId}")
    public ApiResponse<PageResponse<Notification>> list(@PathVariable Long userId,
                                          PageRequest pageRequest) {

        Pageable pageable = org.springframework.data.domain.PageRequest.of(
                pageRequest.getPage() - 1,
                pageRequest.getSize(),
                Sort.by(Sort.Direction.DESC, "createdAt") // 최신순 정렬
        );

        Page<Notification> result = notificationService.loadAllByUserId(userId, pageable);

        return ApiResponse.ok(new PageResponse<>(result.getContent(), pageRequest, result.getTotalElements()));
    }
}
