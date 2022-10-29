package com.roszck.burdock.processors;

import com.roszck.burdock.source.SourceLabeledShare;
import reactor.core.publisher.Mono;

public interface ShareProcessor {

    Mono<KnowledgeSource> process(SourceLabeledShare share);

}
