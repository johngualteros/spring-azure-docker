package com.application.springazuredocker.tag.application.update;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;
import com.application.springazuredocker.tag.domain.exceptions.TagNotFoundException;
import com.application.springazuredocker.tag.domain.model.TagDto;
import com.application.springazuredocker.tag.domain.records.UpdateTagResponse;
import com.application.springazuredocker.tag.infrastructure.entity.TagEntity;
import com.application.springazuredocker.tag.infrastructure.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UpdateTagByUuid {
    /**
     * Logger for register logs in the use case
     * */
    Logger logger = LoggerFactory.getLogger(UpdateTagByUuid.class);
    /**
     * Repository of tags for inject when the class is build
     * */
    public TagRepository tagRepository;
    /**
     * Constructor method
     * @param tagRepository
     * */
    public UpdateTagByUuid(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    /**
     * Method for update a tag
     * @param uuid
     * @param tag
     * @return UpdateTagResponse
     * */
    public UpdateTagResponse execute(String uuid, TagDto tag) throws TagNotFoundException, InvalidArgumentException {
        TagEntity tagEntityForUpdate = tagRepository.findByUuid(uuid);
        if(tagEntityForUpdate == null) {
            logger.error("Tag not found with uuid: " + uuid);
            throw new TagNotFoundException("Tag not found with uuid: " + uuid);
        }
        tagEntityForUpdate.setName(tag.getName());
        tagEntityForUpdate.setColor(tag.getColor());
        tagEntityForUpdate.setDescription(tag.getDescription());
        logger.info("Tag updated with uuid: " + uuid);
        tagRepository.save(tagEntityForUpdate);
        return new UpdateTagResponse(tagEntityForUpdate.getName());
    }
}