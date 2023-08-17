package com.application.springazuredocker.tag.infrastructure.controller;

import com.application.springazuredocker.shared.domain.exceptions.PageNotFoundException;
import com.application.springazuredocker.tag.application.find.GetAllTags;
import com.application.springazuredocker.tag.application.find.GetTagByUuid;
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
    private static String uri = "/api/v1/tags";
    private TagRepository tagRepository;
    private GetAllTags    getAllTagsUseCase;
    private GetTagByUuid  getTagByUuidUseCase;
    public TagRestController(
            TagRepository tagRepository,
            GetAllTags getAllTagsUseCase
    ) {
        this.tagRepository     = tagRepository;
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
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
            pd.setTitle("Page not found");
            pd.setType(URI.create(uri));
            pd.setProperty("Error", e.getMessage());
            return ResponseEntity.status(404).body(pd);
        } catch (Exception e) {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            pd.setTitle("Internal server error");
            pd.setType(URI.create(uri));
            pd.setProperty("Error", e.getMessage());
            return ResponseEntity.status(500).body(pd);
        }
    }
}
