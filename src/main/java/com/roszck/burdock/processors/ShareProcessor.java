package com.roszck.burdock.processors;

import com.roszck.burdock.source.SourceLabeledShare;

public interface ShareProcessor {

    KnowledgeSource process(SourceLabeledShare share);

}
