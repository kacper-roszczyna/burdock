package com.roszck.burdock.source;

public abstract sealed class SourceLabeledShare permits EpubShare, PDFShare, TwitterShare, WebPageShare, YoutubeShare {
}
