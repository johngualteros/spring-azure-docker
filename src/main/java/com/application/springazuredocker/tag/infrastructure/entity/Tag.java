package com.application.springazuredocker.tag.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {
    private Long   id;
    private String name;
    private String color;
    private String description;
    // TODO: add here the owner of tag
}

