package de.carstenkremser.neuefische.asterix.model;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Characters")
public record Character(
        String id,
        @With
        String name,
        int age,
        @With
        String profession
) {
}
