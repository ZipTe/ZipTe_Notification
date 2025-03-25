package com.zipte.notifications.server.adapter.out.mongo.favorite;

import com.zipte.notifications.server.adapter.out.mongo.base.NotificationRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.*;

public interface UserFavoriteDocumentRepository extends NotificationRepository<UserFavoriteDocument,String> {

    @Query(value = "{ 'complexCode' : ?0 }")
    List<UserFavoriteDocument> findUserIdsByComplexCode(String complexCode);


    @Query(value = "{ 'regionCode' : ?0 }", fields = "{ 'userId' : 1, '_id' : 0 }")
    List<Long> findUserIdsByRegionCode(String regionCode);

    void deleteByUserIdAndComplexCode(Long userId, String complexCode);

    void deleteByUserIdAndRegionCode(Long userId, String regionCode);

}
