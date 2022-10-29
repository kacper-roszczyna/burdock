package com.roszck.burdock.source.classification;

import com.roszck.burdock.source.mock.UserMocks;
import com.roszck.burdock.user.UserId;
import com.roszck.burdock.ingestion.domain.FileShare;
import com.roszck.burdock.source.EpubShare;
import com.roszck.burdock.source.ErrorShare;
import com.roszck.burdock.source.PDFShare;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given an instance of FileShareSourceClassifier")
class FileShareSourceClassifierTest {

    private final ShareSourceClassifier sourceClassifier = new FileShareSourceClassifier();
    private final UserId userId = UserMocks.userId;

    @Nested
    @DisplayName("When shared file is an epub")
    class WhenEpub {
        File file = new File("src/test/resources/effective_java.epub");

        @Test
        @DisplayName("Then expect PDFShare to be returned")
        public void test() {
            StepVerifier.create(sourceClassifier.classify(new FileShare(file, userId)))
                    .consumeNextWith(result -> {
                        assertInstanceOf(EpubShare.class, result);
                        assertEquals(file, ((EpubShare) result).getEpub());
                        assertEquals(userId, result.getUserId());
                    })
                    .verifyComplete();

        }
    }

    @Nested
    @DisplayName("When shared file is a pdf")
    class WhenPdf {
        File file = new File("src/test/resources/effective_java.pdf");

        @Test
        @DisplayName("Then expect PDFShare to be returned")
        public void test() {
            StepVerifier.create(sourceClassifier.classify(new FileShare(file, userId)))
                    .consumeNextWith(result -> {
                        assertInstanceOf(PDFShare.class, result);
                        assertEquals(file, ((PDFShare) result).getPdf());
                        assertEquals(userId, result.getUserId());
                    })
                    .verifyComplete();

        }
    }

    @Nested
    @DisplayName("When shared file is something else")
    class WhenElse {

        File file = new File("src/test/resources/effective_java.txt");

        @Test
        @DisplayName("Then expect ErrorShare to be returned")
        public void test() {
            var sourceShare = new FileShare(file, userId);
            StepVerifier.create(sourceClassifier.classify(sourceShare))
                    .consumeNextWith(result -> {
                        assertInstanceOf(ErrorShare.class, result);
                        assertEquals(sourceShare, ((ErrorShare) result).getSource());
                        assertEquals(userId, result.getUserId());
                    }).verifyComplete();

        }

    }

}