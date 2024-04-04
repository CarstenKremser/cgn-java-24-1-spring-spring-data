package de.carstenkremser.neuefische.springdata;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Pets")
public record Pet(
        String id,
        String name,
        String species,
        String owner
) {
}
