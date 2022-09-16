package com.roszck.burdock.source;

import com.roszck.burdock.domain.UserId;

import java.net.URL;

public final class TwitterShare extends SourceLabeledShare {

    private URL url;
    public TwitterShare(UserId userId, URL url) {
        super(userId);
        this.url = url;
    }

}
