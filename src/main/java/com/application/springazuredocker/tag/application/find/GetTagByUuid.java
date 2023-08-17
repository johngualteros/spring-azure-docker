package com.application.springazuredocker.tag.application.find;

import com.application.springazuredocker.shared.domain.exceptions.PageNotFoundException;
import com.application.springazuredocker.tag.domain.exceptions.TagNotFoundException;
import com.application.springazuredocker.tag.domain.mappers.MapperTagToResponse;
import com.application.springazuredocker.tag.domain.records.TagResponse;
import com.application.springazuredocker.tag.infrastructure.entity.TagEntity;
import com.application.springazuredocker.tag.infrastructure.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTagByUuid {
    /**
     * Logger for register logs in the use case
     * */
    Logger logger = LoggerFactory.getLogger(GetAllTags.class);
    /**
     * Repository of tags for inject when the class is build
     * */
    public TagRepository tagRepository;
    /**
     * Constructor method
     * @param tagRepository
     * */
    public GetTagByUuid(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagResponse execute(String uuid) throws TagNotFoundException {
        TagEntity tagEntity = tagRepository.findByUuid(uuid);
        if (tagEntity == null) {
            throw new TagNotFoundException("Tag not found by uuid: " + uuid);
        }
        return MapperTagToResponse.toResponse(tagEntity);
    }
}
