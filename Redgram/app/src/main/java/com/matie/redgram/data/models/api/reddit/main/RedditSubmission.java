package com.matie.redgram.data.models.api.reddit.main;

import com.matie.redgram.data.models.api.reddit.base.RedditObject;

import org.joda.time.DateTime;

/**
 * Created by matie on 17/04/15.
 */
public class RedditSubmission extends RedditObject {

    String banned_by;
    String subreddit;
    boolean saved;
    String id;
    int gilded;
    String author;
    int score;
    String name;
    String likes;
    long created;
    String author_flair_text;
    DateTime created_utc;
    int ups;

    public String getBannedBy() {
        return banned_by;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public boolean isSaved() {
        return saved;
    }

    public String getId() {
        return id;
    }

    public int getGilded() {
        return gilded;
    }

    public String getAuthor() {
        return author;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public long getCreated() {
        return created;
    }

    public String getAuthorFlairText() {
        return author_flair_text;
    }

    public DateTime getCreatedUtc() {
        return created_utc;
    }

    public int getUps() {
        return ups;
    }

    public String getLikes() {
        return likes;
    }
}
