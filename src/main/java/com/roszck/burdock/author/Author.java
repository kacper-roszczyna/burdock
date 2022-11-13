package com.roszck.burdock.author;

import com.roszck.burdock.author.blacklist.Blacklisting;
import com.roszck.burdock.author.channel.PublishingAccount;
import com.roszck.burdock.author.channel.TwitterAccount;
import com.roszck.burdock.author.channel.WebPage;
import com.roszck.burdock.author.channel.YoutubeChannel;

import java.net.URL;
import java.util.List;

public class Author {

    private AuthorId id;
    private String firstName;
    private String lastName;
    private URL avatar;

    private Blacklisting blacklisting;

    private List<TwitterAccount> twitterAccounts;
    private List<YoutubeChannel> youtubeChannels;
    private List<PublishingAccount> publishingAccounts;
    private List<WebPage> webPages;

}
