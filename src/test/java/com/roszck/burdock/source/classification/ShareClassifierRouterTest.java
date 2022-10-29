package com.roszck.burdock.source.classification;

import com.roszck.burdock.ingestion.domain.Share;
import com.roszck.burdock.source.EpubShare;
import com.roszck.burdock.source.PDFShare;
import com.roszck.burdock.source.TwitterShare;
import com.roszck.burdock.source.mock.UserMocks;
import com.roszck.burdock.user.UserId;
import com.roszck.burdock.ingestion.domain.FileShare;
import com.roszck.burdock.ingestion.domain.URLShare;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;

@DisplayName("Given an instance of ShareClassifierRouter")
class ShareClassifierRouterTest {

    private final FileShareSourceClassifier fileClassifier = Mockito.mock(FileShareSourceClassifier.class);
    private final URLShareSourceClassifier urlClassifier = Mockito.mock(URLShareSourceClassifier.class);
    private final ShareClassifierRouter router = new ShareClassifierRouter(fileClassifier, urlClassifier);

    private final UserId userId = UserMocks.userId;
    private final File file = new File("src/test/resources/effective_java.epub");
    private final URL url = new URL("https://twitter.com/GergelyOrosz/status/1570750807540404225");

    ShareClassifierRouterTest() throws MalformedURLException {
    }

    @SneakyThrows
    @BeforeEach
    public void setUp() {
        Mockito.when(fileClassifier.classify(Mockito.any(Share.class))).thenReturn(Mono.just(new EpubShare(file, userId)));
        Mockito.when(urlClassifier.classify(Mockito.any(Share.class))).thenReturn(Mono.just(new TwitterShare(userId, url)));
    }

    @Nested
    @DisplayName("When share contains url")
    class WhenURL {

        @SneakyThrows
        @Test
        @DisplayName("Then expect routing to URLShareSourceClassifier")
        public void then() {
            var sourceShare = new URLShare(
                    url,
                    userId
            );
            StepVerifier.create(router.classify(sourceShare))
                    .expectNextCount(1)
                    .verifyComplete();
            verify(urlClassifier).classify(sourceShare);
        }
    }

    @Nested
    @DisplayName("When share contains file")
    class WhenFile {

        @Test
        @DisplayName("Then expect routing to FileShareSourceClassifier")
        public void then() {
            var sourceShare = new FileShare(
                    file,
                    userId
            );
            StepVerifier.create(router.classify(sourceShare))
                    .expectNextCount(1)
                    .verifyComplete();
            verify(fileClassifier).classify(sourceShare);
        }

    }

}