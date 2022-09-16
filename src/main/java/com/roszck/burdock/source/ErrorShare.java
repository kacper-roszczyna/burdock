package com.roszck.burdock.source;

import com.roszck.burdock.domain.UserId;
import com.roszck.burdock.ingestion.domain.Share;
import lombok.AllArgsConstructor;

public final class ErrorShare extends SourceLabeledShare {
    private Share share;
    private String errorMessage;

    public ErrorShare(Share share, String errorMessage) {
        super(share.getUserId());
        this.share = share;
        this.errorMessage = errorMessage;
    }
}
