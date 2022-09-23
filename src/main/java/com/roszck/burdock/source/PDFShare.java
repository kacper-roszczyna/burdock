package com.roszck.burdock.source;

import com.roszck.burdock.user.UserId;
import lombok.Getter;

import java.io.File;

public final class PDFShare extends SourceLabeledShare {

    @Getter
    private final File pdf;

    public PDFShare(File file, UserId userId) {
        super(userId);
        this.pdf = file;
    }

}
