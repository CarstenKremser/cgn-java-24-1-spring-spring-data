package de.carstenkremser.neuefische.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
