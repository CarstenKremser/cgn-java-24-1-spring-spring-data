package de.carstenkremser.neuefische.asterix.service;

import de.carstenkremser.neuefische.asterix.model.Character;
import de.carstenkremser.neuefische.asterix.repo.CharacterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepo characterRepo;

    public List<Character> getAll() {
        return characterRepo.findAll();
    }

    public List<Character> getByName(String name) {
        return characterRepo.findAllByName(name);
    }

    public List<Character> getByProfession(String profession) {
        return characterRepo.findAllByProfession(profession);
    }

    public List<Character> getOlderThan(int age) {
        return characterRepo.findAllByAgeGreaterThan(age);
    }

    public List<Character> getYoungerThan(int age) {
        return characterRepo.findAllByAgeLessThan(age);
    }

    public double getAverageAgeOfProfession(String profession) {
        return characterRepo
                .findAllByProfession(profession)
                .stream()
                .filter(character -> character.age() > 0)
                .mapToDouble(character -> character.age())
                .average()
                .orElse(0);
    }

    public void saveNewCharacter(Character character) {
        characterRepo.save(character);
    }

    public void updateName(String id, String name) {
        characterRepo
                .findCharacterById(id)
                .ifPresent(character -> characterRepo.save(character.withName(name)));
    }
    public void updateProfession(String id, String profession) {
        characterRepo
                .findCharacterById(id)
                .ifPresent(character -> characterRepo.save(character.withProfession(profession)));
    }

    public void delete(String id) {
        characterRepo
                .findCharacterById(id)
                .ifPresent(characterRepo::delete);
    }


}
