package de.carstenkremser.neuefische.springdata;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepo extends MongoRepository<Weapon, String> {
}
