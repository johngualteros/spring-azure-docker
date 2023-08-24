package com.application.springazuredocker.tag.infrastructure.controller;

import com.application.springazuredocker.shared.domain.exceptions.HttpExceptions;
import com.application.springazuredocker.shared.domain.exceptions.PageNotFoundException;
import com.application.springazuredocker.shared.domain.validators.ExistenceOfAttributes;
import com.application.springazuredocker.tag.application.create.CreateTag;
import com.application.springazuredocker.tag.application.find.GetAllTags;
import com.application.springazuredocker.tag.application.find.GetTagByUuid;
import com.application.springazuredocker.tag.domain.exceptions.TagAlreadyExistsException;
import com.application.springazuredocker.tag.domain.exceptions.TagNotFoundException;
import com.application.springazuredocker.tag.domain.model.TagDto;
import com.application.springazuredocker.tag.domain.records.TagResponse;
import com.application.springazuredocker.tag.infrastructure.repository.TagRepository;
import com.azure.core.annotation.Get;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
public class TagRestController {
    private static final String URL = "/api/v1/tags";
    private final GetAllTags    getAllTagsUseCase;
    private final GetTagByUuid  getTagByUuidUseCase;
    private final CreateTag     createTagUseCase;
    public TagRestController(
            TagRepository tagRepository,
            GetAllTags    getAllTagsUseCase,
            GetTagByUuid  getTagByUuidUseCase,
            CreateTag     createTagUseCase
    ) {
        this.getAllTagsUseCase   = getAllTagsUseCase;
        this.getTagByUuidUseCase = getTagByUuidUseCase;
        this.createTagUseCase    = createTagUseCase;
    }
    /**
     * Method for get all tags
     * @return List<Tag>
     * */
    @GetMapping("/")
    public ResponseEntity<?> getAllTags(@RequestParam("page") Integer page, @RequestParam("size") Integer size) throws PageNotFoundException {
        try {
            ExistenceOfAttributes.validateIsNumberAndPositive(page, "Please send a valid page");
            ExistenceOfAttributes.validateIsNumberAndPositive(size, "Please send a valid size");
            return ResponseEntity.ok(getAllTagsUseCase.execute(page, size));
        } catch (PageNotFoundException e) {
            return HttpExceptions.createProblemResponse(HttpStatus.NOT_FOUND, URL, e.getMessage(), "Page not found", 404);
        } catch (IllegalArgumentException e) {
            return HttpExceptions.createProblemResponse(HttpStatus.BAD_REQUEST, URL, e.getMessage(), "Bad request", 400);
        } catch (Exception e) {
            return HttpExceptions.createProblemResponse(HttpStatus.INTERNAL_SERVER_ERROR, URL, e.getMessage(), "Internal server error", 500);
        }
    }

    /**
     * Method for get a tag by uuid
     * @return Tag UUID
     * @return ResponseEntity<?>
     * */
    @GetMapping("/{uuid}")
    public ResponseEntity<?> getTagByUuid(@PathVariable String uuid) {
        try {
            return ResponseEntity.ok(getTagByUuidUseCase.execute(uuid));
        } catch (TagNotFoundException e) {
            return HttpExceptions.createProblemResponse(HttpStatus.NOT_FOUND, URL, e.getMessage(), "Tag not found", 404);
        } catch (Exception e) {
            return HttpExceptions.createProblemResponse(HttpStatus.INTERNAL_SERVER_ERROR, URL, e.getMessage(), "Internal server error", 500);
        }
    }

    /**
     * Method for create a tag
     * @return TagResponse
     * @return ResponseEntity<?>
     * */
    @PostMapping
    public ResponseEntity<?> createTag(@RequestBody TagDto tag) {
        try {
            return ResponseEntity.created(URI.create(URL)).body(createTagUseCase.execute(tag));
        } catch (TagAlreadyExistsException e) {
            return HttpExceptions.createProblemResponse(HttpStatus.CONFLICT, URL, e.getMessage(), "Tag already exists", 409);
        } catch (Exception e) {
            return HttpExceptions.createProblemResponse(HttpStatus.INTERNAL_SERVER_ERROR, URL, e.getMessage(), "Internal server error", 500);
        }
    }
}
