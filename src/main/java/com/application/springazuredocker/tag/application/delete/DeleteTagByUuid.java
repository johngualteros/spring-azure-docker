package com.application.springazuredocker.tag.application.delete;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;
import com.application.springazuredocker.tag.domain.exceptions.TagNotFoundException;
import com.application.springazuredocker.tag.domain.model.TagDto;
import com.application.springazuredocker.tag.domain.records.DeleteTagResponse;
import com.application.springazuredocker.tag.domain.records.UpdateTagResponse;
import com.application.springazuredocker.tag.infrastructure.entity.TagEntity;
import com.application.springazuredocker.tag.infrastructure.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeleteTagByUuid {
    /**
     * Logger for register logs in the use case
     * */
    Logger logger = LoggerFactory.getLogger(DeleteTagByUuid.class);
    /**
     * Repository of tags for inject when the class is build
     * */
    public TagRepository tagRepository;
    /**
     * Constructor method
     * @param tagRepository
     * */
    public DeleteTagByUuid(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    /**
     * Method for delete a tag
     * @param uuid
     * @return DeleteTagResponse
     * */
    public DeleteTagResponse execute(String uuid) throws TagNotFoundException, InvalidArgumentException {
        TagEntity tagEntityForDelete = tagRepository.findByUuid(uuid);
        if(tagEntityForDelete == null) {
            logger.error("Tag not found with uuid: " + uuid);
            throw new TagNotFoundException("Tag not found with uuid: " + uuid);
        }
        tagRepository.deleteByUuid(uuid);
        return new DeleteTagResponse(tagEntityForDelete.getName());
    }
}
