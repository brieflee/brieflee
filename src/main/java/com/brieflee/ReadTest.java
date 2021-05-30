package com.brieflee;

import com.brieflee.beans.Feed;
import com.brieflee.beans.FeedMessage;
import com.brieflee.services.FeedService;
import com.brieflee.services.FeedServiceImpl;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class ReadTest {


//    public static void main(String[] args) {
//        createFeed();
//    }

    public static void createFeed() {
        FeedServiceImpl feedService = new FeedServiceImpl();
        URL url = feedService.getUrl("https://review.firstround.com/feed.xml");
        Feed feed = feedService.readFeed(url);
        System.out.println(feed);
        for (
                FeedMessage message : feed.getMessages()) {
            System.out.println(message);
        }
    }

}
