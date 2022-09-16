package com.roszck.burdock.source.classification;

import com.roszck.burdock.ingestion.domain.FileShare;
import com.roszck.burdock.ingestion.domain.Share;
import com.roszck.burdock.ingestion.domain.URLShare;
import com.roszck.burdock.source.SourceLabeledShare;

class ShareClassifierRouter implements ShareSourceClassifier {
    private final FileShareSourceClassifier fileClassifier;
    private final URLShareSourceClassifier urlClassifier;

    public ShareClassifierRouter(FileShareSourceClassifier fileClassifier,
                                 URLShareSourceClassifier urlClassifier) {
        this.fileClassifier = fileClassifier;
        this.urlClassifier = urlClassifier;
    }

    @Override
    public SourceLabeledShare classify(Share share) {
        return switch(share) {
            case FileShare fs -> fileClassifier.classify(fs);
            case URLShare us -> urlClassifier.classify(us);
        };
    }
}
