package com.zipte.notifications.server.application.port.out.task;

import java.util.List;

public interface LoadUserFavoritePort {

    // 아파트에 따른 관심 유저 조회하기
    List<Long> loadUserFavoriteByComplexCode(String complexCode);
    List<Long> loadUserFavoriteByRegionCode(String RegionCode);

}
