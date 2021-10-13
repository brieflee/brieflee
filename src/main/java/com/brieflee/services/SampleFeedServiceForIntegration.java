package com.brieflee.services;

import com.brieflee.dto.BSampleRequest;
import com.brieflee.dto.BSampleResponse;

public interface SampleFeedServiceForIntegration {
    BSampleResponse sampleBFeeds(BSampleRequest bSampleRequest);
}
