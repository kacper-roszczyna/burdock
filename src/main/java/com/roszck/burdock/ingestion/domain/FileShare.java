package com.roszck.burdock.ingestion.domain;

import lombok.Getter;

import java.io.File;

public final class FileShare extends Share {

    @Getter
    private File file;

}