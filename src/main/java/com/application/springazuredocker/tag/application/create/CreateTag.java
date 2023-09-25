package com.application.springazuredocker.tag.application.create;

import com.application.springazuredocker.shared.domain.exceptions.PageNotFoundException;
import com.application.springazuredocker.tag.domain.exceptions.TagAlreadyExistsException;
import com.application.springazuredocker.tag.domain.mappers.MapperTagToResponse;
import com.application.springazuredocker.tag.domain.model.TagDto;
import com.application.springazuredocker.tag.domain.records.CreateTagResponse;
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
public class CreateTag {
    /**
     * Logger for register logs in the use case
     * */
    Logger logger = LoggerFactory.getLogger(CreateTag.class);
    /**
     * Repository of tags for inject when the class is build
     * */
    public TagRepository tagRepository;
    /**
     * Constructor method
     * @param tagRepository
     * */
    public CreateTag(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    /**
     * Method for create a tag
     * @return CreateTagResponse
     * */
    public CreateTagResponse execute(TagDto tag) throws TagAlreadyExistsException {
        TagEntity tagEntity = tagRepository.findByName(tag.getName());
        if(tagEntity != null) {
            logger.error("Tag already exists with name: " + tag.getName());
            throw new TagAlreadyExistsException("Tag already exists with name: " + tag.getName());
        }
        // TODO: return the tag created response
        return null;
    }
}
