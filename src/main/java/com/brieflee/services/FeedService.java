package com.brieflee.services;

import com.brieflee.beans.Feed;

import java.net.URL;

public interface FeedService {
    Feed generateFeedFromUrl(final String feedUrl);
}
