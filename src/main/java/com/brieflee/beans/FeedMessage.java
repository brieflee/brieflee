package com.brieflee.beans;

import lombok.Data;

/**
 * Class to represent a feed message.
 */
@Data
public class FeedMessage {
    String title;
    String description;
    String link;
    String author;
    String guid;

    @Override
    public String toString() {
        return "FeedMessage [title=" + title + ", description=" + description
                + ", link=" + link + ", author=" + author + ", guid=" + guid
                + "]";
    }

}
