package org.zjl.jeddit.forum.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.zjl.jeddit.forum.application.commands.CreatePostCommand;
import org.zjl.jeddit.forum.application.commands.UpdatePostCommand;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;

/**
 * @author Junlin Zhou
 */
@Mapper(componentModel = "spring")
public interface PostMapper {

    Post create(CreatePostCommand command);

    Post update(UpdatePostCommand command);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Post update(UpdatePostCommand command, @MappingTarget Post target);

    Post mongoEntityToModel(org.zjl.jeddit.forum.infrastructure.repository.mongo.Post entity);

    //    @Mappings({
//            @Mapping(target = "authorId", source = "model.author.id")
//    })
    org.zjl.jeddit.forum.infrastructure.repository.mongo.Post modelToMongoEntity(Post model);


    default String idConverter(Object id) {
        if (id == null) {
            return null;
        }
        return id.toString();
    }
}
