package com.roszck.burdock.source.classification;

import com.roszck.burdock.ingestion.domain.Share;
import com.roszck.burdock.ingestion.domain.URLShare;
import com.roszck.burdock.source.*;
import reactor.core.publisher.Mono;

import java.net.URL;

class URLShareSourceClassifier implements ShareSourceClassifier {

    private static final String HTTP_PROTOCOL = "http";
    private static final String HTTPS_PROTOCOL = "https";
    private static final String TWITTER_HOST = "twitter.com";
    private static final String YOUTUBE_HOST = "youtu.be";
    @Override
    public Mono<SourceLabeledShare> classify(Share share) {
        URLShare urlShare = (URLShare) share;
        URL source = urlShare.getUrl();
        if(!HTTP_PROTOCOL.equals(source.getProtocol()) && !HTTPS_PROTOCOL.equals(source.getProtocol()))
            return Mono.just(new ErrorShare(share, String.format("Detected protocol not allowed. Detected: %s", source.getProtocol())));
        if(TWITTER_HOST.equals(source.getHost()))
            return Mono.just(new TwitterShare(share.getUserId(), source));
        if(YOUTUBE_HOST.equals(source.getHost()))
            return Mono.just(new YoutubeShare(share.getUserId(), source));
        return Mono.just(new WebPageShare(share.getUserId(), source));
    }

}