package com.brieflee.services;

import com.brieflee.beans.Feed;

public interface FeedService {
    Feed generateFeedFromUrl(final String feedUrl);
}
