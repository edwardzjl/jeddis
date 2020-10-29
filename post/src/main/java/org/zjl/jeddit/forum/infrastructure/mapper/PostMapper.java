package org.zjl.jeddit.forum.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.zjl.jeddit.forum.application.commands.CreatePostCommand;
import org.zjl.jeddit.forum.application.commands.UpdatePostCommand;
import org.zjl.jeddit.forum.domain.model.aggregates.Draft;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;

/**
 * @author Junlin Zhou
 */
@Mapper(componentModel = "spring")
public interface PostMapper {

    Post create(CreatePostCommand command);

    Post createFromDraft(Draft draft);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "author", ignore = true),
            @Mapping(target = "replyTo", ignore = true),
            @Mapping(target = "createTime", ignore = true),
            @Mapping(target = "updateTime", ignore = true)
    })
    Post update(UpdatePostCommand command, @MappingTarget Post target);

}
