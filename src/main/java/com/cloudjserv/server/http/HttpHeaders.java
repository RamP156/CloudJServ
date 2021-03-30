package com.cloudjserv.server.http;

/**
 * @author Ram Pathak
 * Date: Mar 28 2021
 */
public enum HttpHeaders {
    CACHE_CONTROL("Cache-Control"),
    CONTENT_ENCODING("Content-Encoding"),
    CONTENT_LENGTH("Content-Length"),
    CONTENT_TYPE("Content-Type"),
    DATE("Date"),
    ETAG("ETag"),
    EXPIRES("Expires"),
    IF_MATCH("If-Match"),
    IF_MODIFIED_SINCE("If-Modified-Since"),
    IF_NONE_MATCH("If-None-Match"),
    IF_UNMODIFIED_SINCE("If-Unmodified-Since"),
    LAST_MODIFIED("Last-Modified"),
    SERVER("Server");

    String key;

    HttpHeaders(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

}
