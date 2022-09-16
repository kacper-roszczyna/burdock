package com.roszck.burdock.source.classification;

import com.roszck.burdock.ingestion.domain.FileShare;
import com.roszck.burdock.ingestion.domain.Share;
import com.roszck.burdock.source.SourceLabeledShare;

class FileShareSourceClassifier implements ShareSourceClassifier {

    @Override
    public SourceLabeledShare classify(Share share) {
        FileShare fileShare = (FileShare) share;
        return null;
    }

}
