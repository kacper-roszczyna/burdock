package com.roszck.burdock.source.classification;

import com.roszck.burdock.ingestion.domain.Share;
import com.roszck.burdock.source.SourceLabeledShare;
import reactor.core.publisher.Mono;

public interface ShareSourceClassifier {

    Mono<SourceLabeledShare> classify(Share share);

}
