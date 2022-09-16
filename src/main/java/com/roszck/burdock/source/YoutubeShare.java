package com.roszck.burdock.source;

import com.roszck.burdock.domain.UserId;

import java.net.URL;

public final class YoutubeShare extends SourceLabeledShare {

    private URL url;
    public YoutubeShare(UserId userId, URL url) {
        super(userId);
        this.url = url;
    }

}
