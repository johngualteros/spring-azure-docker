package com.application.springazuredocker.tag.infrastructure.controller;

import com.application.springazuredocker.tag.application.find.GetAllTags;
import com.application.springazuredocker.tag.infrastructure.repository.TagRepository;
import com.azure.core.annotation.Get;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tags")
public class TagRestController {
    private TagRepository tagRepository;
    private GetAllTags getAllTagsUseCase;
    public TagRestController(
            TagRepository tagRepository,
            GetAllTags getAllTagsUseCase
    ) {
        this.tagRepository = tagRepository;
        this.getAllTagsUseCase = getAllTagsUseCase;
    }
    @Get("/")
    public String getAllTags() {
        return "Hello world";
    }
}
