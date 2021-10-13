package com.brieflee.beans;

import lombok.Data;

/**
 * Class to represent Author of the feed article.
 */
@Data
public class Author {
    private String name;
    private String authorImageUrl;
    private String authorUrl;
}
