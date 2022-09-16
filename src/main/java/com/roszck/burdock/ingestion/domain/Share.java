package com.roszck.burdock.ingestion.domain;

import com.roszck.burdock.domain.UserId;

public abstract sealed class Share permits FileShare, URLShare {
    protected UserId userId;

    public UserId getUserId() {
        return userId;
    }
}




