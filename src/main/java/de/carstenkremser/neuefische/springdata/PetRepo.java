package de.carstenkremser.neuefische.springdata;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends MongoRepository<Pet, String> {
}
