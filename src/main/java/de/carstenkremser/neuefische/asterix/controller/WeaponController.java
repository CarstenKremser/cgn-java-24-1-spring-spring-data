package de.carstenkremser.neuefische.asterix.controller;

import de.carstenkremser.neuefische.asterix.model.Weapon;
import de.carstenkremser.neuefische.asterix.repo.WeaponRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asterix/weapons")
@RequiredArgsConstructor
public class WeaponController {

    private final WeaponRepo weaponRepo;

    @GetMapping
    List<Weapon> getAll() {
        return weaponRepo.findAll();
    }
 }
