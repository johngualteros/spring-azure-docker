package com.application.springazuredocker.tag.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    @Column
    private String uuid;
    @Column
    private String name;
    @Column
    private String color;
    @Column
    private String description;
    // TODO: add here the owner of tag
}

