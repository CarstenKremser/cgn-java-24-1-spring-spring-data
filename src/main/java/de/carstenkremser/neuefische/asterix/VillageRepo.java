package de.carstenkremser.neuefische.asterix;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepo extends MongoRepository<Village, String> {
}
