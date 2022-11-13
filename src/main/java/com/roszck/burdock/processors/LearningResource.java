package com.roszck.burdock.processors;

import com.roszck.burdock.author.AuthorId;
import com.roszck.burdock.author.channel.ContentChannel;
import com.roszck.burdock.source.SourceLabeledShare;
import com.roszck.burdock.user.UserId;

import java.net.URL;

public abstract class LearningResource {

    private LearningResourceId id;
    private UserId owner;
    private AuthorId author;
    private ContentChannel channel;

    private String title;
    private String summary;
    private URL directLink;
    private LearningResourceType type;
    private URL thumbnailURL;

}
