package com.application.springazuredocker.tag.application.find;

import com.application.springazuredocker.tag.domain.mappers.MapperTagToResponse;
import com.application.springazuredocker.tag.domain.records.TagResponse;
import com.application.springazuredocker.tag.infrastructure.entity.TagEntity;
import com.application.springazuredocker.tag.infrastructure.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTags {
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
    public GetAllTags(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    /**
     * Method for get list of all tags
     * @return List<Tag>
     * */
    public List<TagResponse> execute() {
        logger.info("Searching all tags");
        List<TagEntity> listOfTags = tagRepository.findAll();
        return MapperTagToResponse.listToResponse(listOfTags);
    }
}
