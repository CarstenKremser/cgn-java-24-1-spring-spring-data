package de.carstenkremser.neuefische.springdata;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Weapons")
public record Weapon(
        String id,
        String kind,
        String owner
) {
}
