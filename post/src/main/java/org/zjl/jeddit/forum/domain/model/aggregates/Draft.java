package org.zjl.jeddit.forum.domain.model.aggregates;

import java.time.LocalDateTime;

/**
 * Draft, aka not published post.
 * Use a different class for further flexibility.
 *
 * @author Junlin Zhou
 */
public class Draft extends Post {

    LocalDateTime plannedDate;

}
