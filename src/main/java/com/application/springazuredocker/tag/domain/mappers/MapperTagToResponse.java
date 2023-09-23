package com.application.springazuredocker.tag.domain.mappers;

import com.application.springazuredocker.tag.domain.records.TagResponse;
import com.application.springazuredocker.tag.infrastructure.entity.TagEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class MapperTagToResponse {
    public static List<TagResponse> listToResponse(List<TagEntity> listOfTags) {
        return listOfTags.stream().map(tag -> new TagResponse(tag.getUuid(),
               tag.getName(),
               tag.getColor(),
               tag.getDescription()
       )).collect(Collectors.toList());
    }
    public static TagResponse toResponse(TagEntity tag) {
        return new TagResponse(
                tag.getUuid(),
                tag.getName(),
                tag.getColor(),
                tag.getDescription()
        );
    }
}
