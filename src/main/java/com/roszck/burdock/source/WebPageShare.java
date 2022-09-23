package com.roszck.burdock.source;

import com.roszck.burdock.user.UserId;

import java.net.URL;

public final class WebPageShare extends SourceLabeledShare {

    private URL url;
    public WebPageShare(UserId userId, URL url) {
        super(userId);
        this.url = url;
    }

}
