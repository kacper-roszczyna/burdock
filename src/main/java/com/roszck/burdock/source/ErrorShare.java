package com.roszck.burdock.source;

import com.roszck.burdock.ingestion.domain.Share;

public final class ErrorShare extends SourceLabeledShare {
    private final Share share;
    private final String errorMessage;

    public ErrorShare(Share share, String errorMessage) {
        super(share.getUserId());
        this.share = share;
        this.errorMessage = errorMessage;
    }

    public Share getSource() {
        return share;
    }
}
