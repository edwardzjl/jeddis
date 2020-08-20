package org.zjl.jeddit.forum.infrustructure.mapper;

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

    Post mongoEntityToModel(org.zjl.jeddit.forum.infrustructure.repository.mongo.Post entity);

    org.zjl.jeddit.forum.infrustructure.repository.mongo.Post modelToMongoEntity(Post model);

    @Mappings(
            @Mapping(target = "id", ignore = true) // do not update id
    )
    org.zjl.jeddit.forum.infrustructure.repository.mongo.Post update(
            Post source,
            @MappingTarget org.zjl.jeddit.forum.infrustructure.repository.mongo.Post target);

    @Mappings(
            @Mapping(target = "id", ignore = true) // do not update id
    )
    org.zjl.jeddit.forum.infrustructure.repository.mongo.Post update(Post source, @MappingTarget Post target);

    default Flux<Post> mongoEntityToModel(Flux<org.zjl.jeddit.forum.infrustructure.repository.mongo.Post> flux) {
        return flux.map(this::mongoEntityToModel);
    }

    default Flux<org.zjl.jeddit.forum.infrustructure.repository.mongo.Post> modelToMongoEntity(Flux<Post> flux) {
        return flux.map(this::modelToMongoEntity);
    }

}
