package de.carstenkremser.neuefische.springdata;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Characters")
public record Character(
        String id,
        String name,
        int age,
        String profession
) {
}
