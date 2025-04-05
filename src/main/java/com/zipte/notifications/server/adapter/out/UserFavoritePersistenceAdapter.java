package com.zipte.notifications.server.adapter.out;

import com.zipte.notifications.server.adapter.out.mongo.favorite.UserFavoriteDocument;
import com.zipte.notifications.server.adapter.out.mongo.favorite.UserFavoriteDocumentRepository;
import com.zipte.notifications.server.application.port.out.task.DeleteUserFavoritePort;
import com.zipte.notifications.server.application.port.out.task.LoadUserFavoritePort;
import com.zipte.notifications.server.application.port.out.task.SaveUserFavoritePort;
import com.zipte.notifications.server.domain.UserFavoriteNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFavoritePersistenceAdapter implements SaveUserFavoritePort, LoadUserFavoritePort,DeleteUserFavoritePort {

    private final UserFavoriteDocumentRepository repository;

    @Override
    public UserFavoriteNotification saveUserFavorite(UserFavoriteNotification notification) {
        var document = UserFavoriteDocument.from(notification);

        return repository.save(document)
                .toDomain();
    }

    @Override
    public List<Long> loadUserFavoriteByComplexCode(String complexCode) {
        return repository.findUserIdsByComplexCode(complexCode).stream()
                .map(UserFavoriteDocument::getUserId)
                .toList();
    }

    @Override
    public List<Long> loadUserFavoriteByRegionCode(String regionCode) {
        return repository.findUserIdsByRegionCode(regionCode);
    }


    @Override
    public void deleteByUserIdAndComplexCode(Long userId, String complexCode) {
        repository.deleteByUserIdAndComplexCode(userId, complexCode);

    }

    @Override
    public void deleteByUserIdAndRegionCode(Long userId, String regionCode) {
        repository.deleteByUserIdAndRegionCode(userId, regionCode);
    }


}
