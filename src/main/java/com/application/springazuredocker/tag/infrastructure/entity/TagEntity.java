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

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

