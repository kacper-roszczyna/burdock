package com.roszck.burdock.source.classification;

import com.roszck.burdock.source.mock.UserMocks;
import com.roszck.burdock.user.UserId;
import com.roszck.burdock.ingestion.domain.URLShare;
import com.roszck.burdock.source.ErrorShare;
import com.roszck.burdock.source.TwitterShare;
import com.roszck.burdock.source.WebPageShare;
import com.roszck.burdock.source.YoutubeShare;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given an instance of URLShareSourceClassifier")
class URLShareSourceClassifierTest {

    private final URLShareSourceClassifier classifier = new URLShareSourceClassifier();
    private final UserId userId = UserMocks.userId;

    @Nested
    @DisplayName("When Tweet in a share")
    class WhenTweet {

        private final URLShare urlShare = new URLShare(
                new URL("https://twitter.com/GergelyOrosz/status/1570750807540404225"),
                userId
        );

        WhenTweet() throws MalformedURLException {
        }

        @SneakyThrows
        @Test
        @DisplayName("Then expect TwitterShare returned")
        public void thenTwitterShare() {
            URLShare urlShare = new URLShare(
                    new URL("https://twitter.com/GergelyOrosz/status/1570750807540404225"),
                    userId
            );
            assertInstanceOf(TwitterShare.class, classifier.classify(urlShare));
        }

    }

    @Nested
    @DisplayName("When YT video in a share")
    class WhenYT {

        private final URLShare urlShare = new URLShare(
                new URL("https://youtu.be/zFleLL5zlal"),
                userId
        );

        WhenYT() throws MalformedURLException {
        }

        @Test
        @DisplayName("Then expect YoutubeShare returned")
        public void thenYTShare() {
            assertInstanceOf(YoutubeShare.class, classifier.classify(urlShare));
        }

    }

    @Nested
    @DisplayName("When generic web page")
    class WhenWebPage {

        private final URLShare urlShare = new URLShare(
                new URL("https://martinfowler.com/807540404225"),
                userId
        );

        WhenWebPage() throws MalformedURLException {
        }

        @Test
        @DisplayName("Then expect a WebPageShare")
        public void thenWebPageShare() {
            assertInstanceOf(WebPageShare.class, classifier.classify(urlShare));
        }

    }

    @Nested
    @DisplayName("When incorrect url")
    class WhenIncorrect {

        private final URLShare urlShare = new URLShare(
                new URL("file://martinfowler.com/807540404225"),
                userId
        );

        WhenIncorrect() throws MalformedURLException {
        }

        @Test
        @DisplayName("Then expect a ErrorShare")
        public void thenError() {
            assertInstanceOf(ErrorShare.class, classifier.classify(urlShare));
        }

    }

}