package com.zipte.notifications.server.adapter.out.mongo.property;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PropertyDocumentRepository extends MongoRepository<PropertyDocument,String> {

    Optional<PropertyDocument> findByComplexCode(String complexCode);

    void deleteByComplexCode(String complexCode);

}
