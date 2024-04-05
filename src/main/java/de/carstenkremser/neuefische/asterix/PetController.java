package de.carstenkremser.neuefische.asterix;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asterix/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetRepo petRepo;

    @GetMapping
    List<Pet> getAll() {
        return petRepo.findAll();
    }
}
