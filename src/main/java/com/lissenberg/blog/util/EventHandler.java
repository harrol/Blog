package com.lissenberg.blog.util;

import com.lissenberg.blog.domain.BlogPost;

import javax.enterprise.event.Observes;
import java.util.logging.Logger;

/**
 * @author Harro Lissenberg
 */
public class EventHandler {

    Logger LOG = Logger.getLogger(EventHandler.class.getName());


    public void handleEvent(@Observes BlogPost post) {
        LOG.info("New blogpost added " + post.getTitle());
    }
}
