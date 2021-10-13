package com.brieflee.dto;


import com.brieflee.beans.Author;
import com.brieflee.beans.BTag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor@NoArgsConstructor
public class BSampleFeed {
    private String headerImageUrl;
    private List<BTag> tags;
    private String title;
    private String body;
    private String articleUrl;
    private Author author;
}
