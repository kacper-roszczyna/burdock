package com.roszck.burdock.author;

import java.net.URL;
import java.util.List;

public class Author {

    private AuthorId id;
    private String firstName;
    private String lastName;
    private URL avatar;

    private List<TwitterAccount> twitterAccounts;
    private List<YoutubeAccount> youtubeAccounts;
    private List<PublishingAccount> publishingAccounts;
    private List<WebPage> webPages;

}
