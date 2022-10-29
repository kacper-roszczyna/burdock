package com.roszck.burdock.author;

import com.roszck.burdock.author.channel.ContentChannel;
import reactor.core.publisher.Mono;

public interface AuthorRepository {

    Mono<Author> getByChannel(ContentChannel channel);

}
