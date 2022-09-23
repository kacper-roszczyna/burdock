package com.roszck.burdock.ingestion.domain;

import com.roszck.burdock.user.UserId;

public abstract sealed class Share permits FileShare, URLShare {
    protected final UserId userId;

    protected Share(UserId userId) {
        this.userId = userId;
    }

    public UserId getUserId() {
        return userId;
    }
}




