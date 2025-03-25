package com.zipte.notifications.server.adapter.out;

import com.zipte.notifications.server.adapter.out.mongo.property.PropertyDocumentRepository;
import com.zipte.notifications.server.adapter.out.mongo.property.PropertyDocument;
import com.zipte.notifications.server.application.port.out.task.DeletePropertyPort;
import com.zipte.notifications.server.application.port.out.task.SavePropertyPort;
import com.zipte.notifications.server.domain.PropertyNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PropertyPersistenceAdapter implements SavePropertyPort, DeletePropertyPort {

    private final PropertyDocumentRepository repository;

    @Override
    public PropertyNotification saveNotification(PropertyNotification notification) {
        var document = PropertyDocument.from(notification);

        return repository.save(document)
                .toDomain();
    }

    @Override
    public void deleteCommentNotification(String complexCode) {
        repository.deleteById(complexCode);
    }
}
