package com.cardoso.publication.controller;

import com.cardoso.publication.domain.Publication;
import com.cardoso.publication.mapper.PublicationMapper;
import com.cardoso.publication.service.PublicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;
    @Autowired
    private PublicationMapper publicationMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody PublicationRequest publicationRequest) {
        var publication = publicationMapper.toPublication(publicationRequest);
        publicationService.insert(publication);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publication> findAll() {
        return publicationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publication findById(@PathVariable("id") String id) {
        return publicationService.findById(id);
    }
}
