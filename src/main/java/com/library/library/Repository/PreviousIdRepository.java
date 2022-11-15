package com.library.library.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.library.library.Model.PreviousId;

public interface PreviousIdRepository extends MongoRepository<PreviousId, String> {
    PreviousId findByType(String type);
    PreviousId save(PreviousId previousId);
}
