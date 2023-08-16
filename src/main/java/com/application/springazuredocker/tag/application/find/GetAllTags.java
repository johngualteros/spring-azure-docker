package com.application.springazuredocker.tag.application.find;

import com.application.springazuredocker.shared.domain.exceptions.PageNotFoundException;
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
    public List<TagResponse> execute(Integer page, Integer size) throws PageNotFoundException {
        logger.info("Searching all tags");
        Pageable pageable = PageRequest.of(page, size);
        // validate if the page is less than 0
        if (page < 0) {
            logger.error("The page is less than 0");
            throw new PageNotFoundException("The page is less than 0");
        }
        // validate if the max size is greater than 100 then only return 100
        if (size > 100) {
            logger.warn("The size is greater than 100");
            size = 100;
        }
        Page<TagEntity> pageableOfTags = tagRepository.findAll(pageable);
        List<TagEntity> listOfTags = pageableOfTags.toList();
        logger.info("Returning all tags");
        return MapperTagToResponse.listToResponse(listOfTags);
    }
}
