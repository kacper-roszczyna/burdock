package com.roszck.burdock.ingestion.domain;

import com.roszck.burdock.user.UserId;
import lombok.Getter;

import java.io.File;

public final class FileShare extends Share {

    @Getter
    private final File file;

    public FileShare(File file, UserId userId) {
        super(userId);
        this.file = file;
    }
}