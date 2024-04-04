package de.carstenkremser.neuefische.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterRepo characterRepo;

    @GetMapping
    List<Character> getAll() {
        return characterRepo.findAll();
    }

    @PostMapping
    void saveNewCharacter(@RequestBody Character character) {
        characterRepo.save(character);
    }

    @PutMapping("/updateName/{id}/{name}")
    void updateName(@PathVariable String id, @PathVariable String name) {
        characterRepo
                .findCharacterById(id)
                .ifPresent(character -> characterRepo.save(character.withName(name)));
    }

    @PutMapping("/updateProfession/{id}/{profession}")
    void updateProfession(@PathVariable String id, @PathVariable String profession) {
        characterRepo
                .findCharacterById(id)
                .ifPresent(character -> characterRepo.save(character.withProfession(profession)));
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable String id) {
        characterRepo
                .findCharacterById(id)
                .ifPresent(characterRepo::delete);
    }

    @GetMapping("/byName/{name}")
    List<Character> getByName(@PathVariable String name) {
        return characterRepo.findAllByName(name);
    }
    @GetMapping("/byProfession/{profession}")
    List<Character> getByProfession(@PathVariable String profession) {
        return characterRepo.findAllByProfession(profession);
    }
    @GetMapping("/olderThan/{age}")
    List<Character> getOlderThan(@PathVariable int age) {
        return characterRepo.findAllByAgeGreaterThan(age);
    }

    @GetMapping("/youngerThan/{age}")
    List<Character> getYoungerThan(@PathVariable int age) {
        return characterRepo.findAllByAgeLessThan(age);
    }

    @GetMapping("/averageAgeOfProfession/{profession}")
    double getAverageAgeOfProfession(@PathVariable String profession) {
        return characterRepo
                .findAllByProfession(profession)
                .stream()
                .filter(character -> character.age() > 0)
                .mapToDouble(character -> character.age())
                .average()
                .orElse(0);
    }
}
