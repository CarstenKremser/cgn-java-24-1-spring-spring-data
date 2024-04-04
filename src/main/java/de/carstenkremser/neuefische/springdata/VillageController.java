package de.carstenkremser.neuefische.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asterix/villages")
@RequiredArgsConstructor
public class VillageController {

    private final VillageRepo villageRepo;

    @GetMapping
    List<Village> getAll() {
        return villageRepo.findAll();
    }
}
