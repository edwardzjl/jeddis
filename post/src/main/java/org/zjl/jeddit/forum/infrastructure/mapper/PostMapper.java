package org.zjl.jeddit.forum.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.zjl.jeddit.forum.application.commands.CreatePostCommand;
import org.zjl.jeddit.forum.application.commands.UpdatePostCommand;
import org.zjl.jeddit.forum.domain.model.aggregates.Draft;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;
import org.zjl.jeddit.forum.domain.model.valueobjects.PostId;

/**
 * @author Junlin Zhou
 */
@Mapper(componentModel = "spring")
public interface PostMapper {

    Post create(CreatePostCommand command);

    Post createFromDraft(Draft draft);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Post update(UpdatePostCommand command, @MappingTarget Post target);

    Post mongoEntityToModel(org.zjl.jeddit.forum.infrastructure.repository.mongo.Post entity);

    org.zjl.jeddit.forum.infrastructure.repository.mongo.Post modelToMongoEntity(Post model);

    default PostId toModelId(String entityId) {
        if (entityId == null) {
            return null;
        }
        return PostId.of(entityId);
    }

    default String toEntityId(PostId modelId) {
        if (modelId == null) {
            return null;
        }
        return modelId.getStringId();
    }
}
