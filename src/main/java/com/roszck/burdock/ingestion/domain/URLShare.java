package com.roszck.burdock.ingestion.domain;

import com.roszck.burdock.domain.UserId;
import lombok.Getter;

import java.net.URL;

public final class URLShare extends Share {

    @Getter
    private final URL url;

    public URLShare(URL url, UserId userId) {
        super(userId);
        this.url = url;
    }
}
