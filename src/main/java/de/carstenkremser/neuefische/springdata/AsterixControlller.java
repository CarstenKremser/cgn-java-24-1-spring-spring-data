package de.carstenkremser.neuefische.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor
public class AsterixControlller {

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
}
