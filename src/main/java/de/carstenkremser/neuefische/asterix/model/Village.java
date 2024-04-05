package de.carstenkremser.neuefische.asterix.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Villages")
public record Village(
        String id,
        String name,
        String belongsTo
) {
}
