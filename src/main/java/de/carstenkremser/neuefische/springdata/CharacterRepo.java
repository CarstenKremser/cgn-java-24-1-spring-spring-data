package de.carstenkremser.neuefische.springdata;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepo extends MongoRepository<Character, String> {
    Optional<Character> findCharacterById(String id);

    List<Character> findAllByName (String name);
    List<Character> findAllByProfession(String profession);
    List<Character> findAllByAgeGreaterThan(int age);
    List<Character> findAllByAgeLessThan(int age);
}
