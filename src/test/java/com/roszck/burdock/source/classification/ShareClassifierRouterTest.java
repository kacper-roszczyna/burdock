package com.roszck.burdock.source.classification;

import com.roszck.burdock.user.UserId;
import com.roszck.burdock.ingestion.domain.FileShare;
import com.roszck.burdock.ingestion.domain.URLShare;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.net.URL;

import static org.mockito.Mockito.verify;

@DisplayName("Given an instance of ShareClassifierRouter")
class ShareClassifierRouterTest {

    private final FileShareSourceClassifier fileClassifier = Mockito.mock(FileShareSourceClassifier.class);
    private final URLShareSourceClassifier urlClassifier = Mockito.mock(URLShareSourceClassifier.class);
    private final ShareClassifierRouter router = new ShareClassifierRouter(fileClassifier, urlClassifier);

    private final UserId userId = new UserId();

    @Nested
    @DisplayName("When share contains url")
    class WhenURL {

        @SneakyThrows
        @Test
        @DisplayName("Then expect routing to URLShareSourceClassifier")
        public void then() {
            var sourceShare = new URLShare(
                    new URL("https://twitter.com/GergelyOrosz/status/1570750807540404225"),
                    userId
            );
            router.classify(sourceShare);
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
                    new File("src/test/resources/effective_java.epub"),
                    userId
            );
            router.classify(sourceShare);
            verify(fileClassifier).classify(sourceShare);
        }

    }

}