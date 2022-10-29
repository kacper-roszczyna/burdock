package com.roszck.burdock.author.channel;

import com.roszck.burdock.source.SourceLabeledShare;
import reactor.core.publisher.Mono;

public interface ShareChannelProvider {

    Mono<ContentChannel> from(SourceLabeledShare share);

}
