package com.application.springazuredocker.tag.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tag")
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    @Column(nullable = false)
    private String uuid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;
    @Column(nullable = true)
    private String description;
    // TODO: add here the owner of tag

    public TagEntity(Long id, String uuid, String name, String color, String description) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.color = color;
        this.description = description;
    }

    public TagEntity(String uuid, String name, String color, String description) {
        this.uuid = uuid;
        this.name = name;
        this.color = color;
        this.description = description;
    }

    public TagEntity() {}
}
