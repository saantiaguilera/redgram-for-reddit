package com.matie.redgram.data.network.api.reddit.base;

import android.util.Base64;

import com.matie.redgram.data.network.api.ApiBase;

/**
 * Created by matie on 15/04/15.
 * Check for nulls before using the methods.
 */
public class RedditServiceBase extends ApiBase {

    public static final String SSL = "https://";
    public static final char SEP = '/';
    public static final String REDDIT_HOST = "www.reddit.com";
    public static final String OAUTH_HOST = "oauth.reddit.com";
    public static final String REDDIT_HOST_ABSOLUTE = SSL+REDDIT_HOST+SEP;
    public static final String OAUTH_HOST_ABSOLUTE = SSL+OAUTH_HOST+SEP;
    public static final String NAMESPACE = "api/v1/";
    public static final String OAUTH_URL = "authorize?client_id={client_id}&response_type=code&state=TEST&redirect_uri={redirect_uri}&duration={duration}&scope={scope}";
    public static final String scopeList = "identity,edit,history,mysubreddits,privatemessages," +
            "read,report,save,submit,subscribe,vote,wikiread";
    public static final String REDIRECT_URI = "http://localhost";
    public static final String DURATION = "permanent";
    public static final String GRANT_TYPE_REFRESH="refresh_token";
    public static final String GRANT_TYPE_AUTHORIZE="authorization_code";

    public static final String API_KEY = "TK68m6qyOWxMZg";
    private static final String API_SECRET = "";
    private static final String CREDENTIALS = API_KEY+":"+API_SECRET;

    @Override
    public String getKey() {
        return API_KEY;
    }

    @Override
    public String getSecret() {
        return API_SECRET;
    }


    public String getCredentials() {
        return "Basic " +
                Base64.encodeToString(CREDENTIALS.getBytes(), Base64.NO_WRAP);
    }
}
