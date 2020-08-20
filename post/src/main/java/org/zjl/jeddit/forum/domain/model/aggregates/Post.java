package org.zjl.jeddit.forum.domain.model.aggregates;

import org.zjl.jeddit.forum.domain.model.valueobjects.User;

/**
 * @author Junlin Zhou
 */
public class Post {

    private User author;

    private Post replyTo;

    private String title;

    private String content;

}
