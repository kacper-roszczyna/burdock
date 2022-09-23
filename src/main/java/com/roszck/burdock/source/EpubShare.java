package com.roszck.burdock.source;

import com.roszck.burdock.user.UserId;
import lombok.Getter;

import java.io.File;

public final class EpubShare extends SourceLabeledShare {

    @Getter
    private final File epub;

    public EpubShare(File file, UserId userId) {
        super(userId);
        this.epub = file;
    }
}
