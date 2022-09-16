package com.roszck.burdock.source.classification;

import com.roszck.burdock.ingestion.domain.Share;
import com.roszck.burdock.source.SourceLabeledShare;

public interface ShareSourceClassifier {

    SourceLabeledShare classify(Share share);

}
