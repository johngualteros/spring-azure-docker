package com.application.springazuredocker.tag.infrastructure.controller;

import com.application.springazuredocker.shared.domain.exceptions.HttpExceptions;
import com.application.springazuredocker.shared.domain.exceptions.PageNotFoundException;
import com.application.springazuredocker.tag.application.find.GetAllTags;
import com.application.springazuredocker.tag.application.find.GetTagByUuid;
import com.application.springazuredocker.tag.domain.exceptions.TagNotFoundException;
import com.application.springazuredocker.tag.domain.records.TagResponse;
import com.application.springazuredocker.tag.infrastructure.repository.TagRepository;
import com.azure.core.annotation.Get;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
public class TagRestController {
    private static final String URL = "/api/v1/tags";
    private final GetAllTags    getAllTagsUseCase;
    private GetTagByUuid  getTagByUuidUseCase;
    public TagRestController(
            TagRepository tagRepository,
            GetAllTags getAllTagsUseCase
    ) {
        this.getAllTagsUseCase = getAllTagsUseCase;
    }
    /**
     * Method for get all tags
     * @return List<Tag>
     * */
    @Get("/")
    public ResponseEntity<?> getAllTags(@RequestParam("page") Integer page, @RequestParam("size") Integer size) throws PageNotFoundException {
        try {
            return ResponseEntity.ok(getAllTagsUseCase.execute(page, size));
        } catch (PageNotFoundException e) {
            return HttpExceptions.createProblemResponse(HttpStatus.NOT_FOUND, URL, e.getMessage(), "Page not found", 404);
        } catch (Exception e) {
            return HttpExceptions.createProblemResponse(HttpStatus.INTERNAL_SERVER_ERROR, URL, e.getMessage(), "Internal server error", 500);
        }
    }

    @Get("/{uuid}")
    public ResponseEntity<?> getTagByUuid(@RequestParam("uuid") String uuid) {
        try {
            return ResponseEntity.ok(getTagByUuidUseCase.execute(uuid));
        } catch (TagNotFoundException e) {
            return HttpExceptions.createProblemResponse(HttpStatus.NOT_FOUND, URL, e.getMessage(), "Tag not found", 404);
        } catch (Exception e) {
            return HttpExceptions.createProblemResponse(HttpStatus.INTERNAL_SERVER_ERROR, URL, e.getMessage(), "Internal server error", 500);
        }
    }
}
