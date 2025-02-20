package com.cardoso.publication.mapper;

import com.cardoso.publication.controller.PublicationRequest;
import com.cardoso.publication.domain.Publication;
import com.cardoso.publication.repository.entity.PublicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {
    PublicationEntity toPublicationEntity(Publication publication);

    Publication toPublication(PublicationEntity publicationEntity);

    Publication toPublication(PublicationRequest publicationRequest);
}
