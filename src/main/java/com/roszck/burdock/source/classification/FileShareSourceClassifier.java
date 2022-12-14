package com.roszck.burdock.source.classification;

import com.roszck.burdock.ingestion.domain.FileShare;
import com.roszck.burdock.ingestion.domain.Share;
import com.roszck.burdock.source.EpubShare;
import com.roszck.burdock.source.ErrorShare;
import com.roszck.burdock.source.PDFShare;
import com.roszck.burdock.source.SourceLabeledShare;
import org.apache.commons.io.FilenameUtils;
import reactor.core.publisher.Mono;

class FileShareSourceClassifier implements ShareSourceClassifier {

    public static final String EPUB = "epub";
    public static final String PDF = "pdf";

    @Override
    public Mono<SourceLabeledShare> classify(Share share) {
        FileShare fileShare = (FileShare) share;
        var file = fileShare.getFile();
        var extension = FilenameUtils.getExtension(file.getName());
        if (EPUB.equalsIgnoreCase(extension))
            return Mono.just(new EpubShare(file, share.getUserId()));
        if (PDF.equalsIgnoreCase(extension))
            return Mono.just(new PDFShare(file, share.getUserId()));
        return Mono.just(new ErrorShare(share, "Unrecognized file type"));
    }

}
