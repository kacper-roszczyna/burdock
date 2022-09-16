package com.roszck.burdock.source;

import com.roszck.burdock.domain.UserId;
import lombok.Getter;

public abstract sealed class SourceLabeledShare permits EpubShare, ErrorShare, PDFShare, TwitterShare, WebPageShare, YoutubeShare {

    @Getter
    protected UserId userId;

    public SourceLabeledShare(UserId userId) {
        this.userId = userId;
    }
}
