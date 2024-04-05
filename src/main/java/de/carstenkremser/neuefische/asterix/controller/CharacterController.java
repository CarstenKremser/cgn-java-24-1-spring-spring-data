package de.carstenkremser.neuefische.asterix.controller;

import de.carstenkremser.neuefische.asterix.model.Character;
import de.carstenkremser.neuefische.asterix.repo.CharacterRepo;
import de.carstenkremser.neuefische.asterix.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;
    @GetMapping
    List<Character> getAll() {
        return characterService.getAll();
    }

    @PostMapping
    void saveNewCharacter(@RequestBody Character character) {
        characterService.saveNewCharacter(character);
    }

    @PutMapping("/updateName/{id}/{name}")
    void updateName(@PathVariable String id, @PathVariable String name) {
        characterService.updateName(id, name);
    }

    @PutMapping("/updateProfession/{id}/{profession}")
    void updateProfession(@PathVariable String id, @PathVariable String profession) {
        characterService.updateProfession(id, profession);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable String id) {
        characterService.delete(id);
    }

    @GetMapping("/byName/{name}")
    List<Character> getByName(@PathVariable String name) {
        return characterService.getByName(name);
    }

    @GetMapping("/byProfession/{profession}")
    List<Character> getByProfession(@PathVariable String profession) {
        return characterService.getByProfession(profession);
    }

    @GetMapping("/olderThan/{age}")
    List<Character> getOlderThan(@PathVariable int age) {
        return characterService.getOlderThan(age);
    }

    @GetMapping("/youngerThan/{age}")
    List<Character> getYoungerThan(@PathVariable int age) {
        return characterService.getYoungerThan(age);
    }

    @GetMapping("/averageAgeOfProfession/{profession}")
    double getAverageAgeOfProfession(@PathVariable String profession) {
        return characterService.getAverageAgeOfProfession(profession);
    }
}
