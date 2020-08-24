package org.zjl.jeddit.forum.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;
import reactor.core.publisher.Flux;

/**
 * @author Junlin Zhou
 */
@Mapper(componentModel = "spring")
public interface PostMapper {

    Post mongoEntityToModel(org.zjl.jeddit.forum.infrastructure.repository.mongo.Post entity);

    @Mappings({
            @Mapping(target = "authorId", source = "model.author.id")
    })
    org.zjl.jeddit.forum.infrastructure.repository.mongo.Post modelToMongoEntity(Post model);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "version", ignore = true)
    })
    Post update(Post source, @MappingTarget Post target);

    default Flux<Post> mongoEntityToModel(Flux<org.zjl.jeddit.forum.infrastructure.repository.mongo.Post> flux) {
        return flux.map(this::mongoEntityToModel);
    }

    default Flux<org.zjl.jeddit.forum.infrastructure.repository.mongo.Post> modelToMongoEntity(Flux<Post> flux) {
        return flux.map(this::modelToMongoEntity);
    }

}
