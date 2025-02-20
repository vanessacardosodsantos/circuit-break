package com.cardoso.publication.service;

import com.cardoso.publication.domain.Publication;
import com.cardoso.publication.mapper.PublicationMapper;
import com.cardoso.publication.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private PublicationMapper publicationMapper;
    @Autowired
    private CommentService commentService;

    public void insert(Publication publication) {
        var publicationEntity = publicationMapper.toPublicationEntity(publication);
        publicationRepository.save(publicationEntity);
    }

    public List<Publication> findAll() {
        var publications = publicationRepository.findAll();
        return publications.stream().map(publicationMapper::toPublication).toList();
    }

    public Publication findById(String id) {
        var publication = publicationRepository.findById(id)
                .map(publicationMapper::toPublication)
                .orElseThrow(RuntimeException::new);

        var comments = commentService.getComments(id);
        publication.setComments(comments);
        return publication;
    }
}
