package de.carstenkremser.neuefische.springdata;

public record Character(
        String id,
        String name,
        int age,
        String profession
) {
}
