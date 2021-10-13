package com.brieflee.api.userApi;

import com.brieflee.beans.Feed;
import com.brieflee.dto.BFeedRequest;
import com.brieflee.dto.BSampleRequest;
import com.brieflee.dto.BSampleResponse;
import com.brieflee.services.FeedService;

import com.brieflee.services.SampleFeedServiceForIntegration;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("v1/")
public class FeedApi {

    private final FeedService feedService;
    private final SampleFeedServiceForIntegration sampleFeedServiceForIntegration;

    @PostMapping(value = "feed", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Feed> generateBFeedFromUrl(@RequestBody BFeedRequest bFeedRequest) {
        Feed feed = feedService.generateFeedFromUrl(bFeedRequest.getFeedUrl());
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }

    @PostMapping(value = "sample", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BSampleResponse> generateSampleBFeed(@RequestBody BSampleRequest bSampleRequest) {
        BSampleResponse bSampleResponse = sampleFeedServiceForIntegration.sampleBFeeds(bSampleRequest);
        return new ResponseEntity<>(bSampleResponse, HttpStatus.OK);
    }
}
