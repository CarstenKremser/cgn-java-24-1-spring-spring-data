package de.carstenkremser.neuefische.asterix.repo;

import de.carstenkremser.neuefische.asterix.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends MongoRepository<Pet, String> {
}
