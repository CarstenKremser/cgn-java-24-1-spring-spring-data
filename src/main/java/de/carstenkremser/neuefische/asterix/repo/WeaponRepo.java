package de.carstenkremser.neuefische.asterix.repo;

import de.carstenkremser.neuefische.asterix.model.Weapon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepo extends MongoRepository<Weapon, String> {
}
