package com.roszck.burdock.processors;

import com.roszck.burdock.source.SourceLabeledShare;
import reactor.core.publisher.Flux;

public interface ShareProcessor {

    Flux<LearningResource> process(SourceLabeledShare share);

}
