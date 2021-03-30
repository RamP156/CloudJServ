package com.cloudjserv.server.http;

import java.util.List;

/**
 * @author Ram Pathak
 * Date: Mar 28 2021
 */
public class CacheControl {

    private boolean privateDirective;
    private List<String> privateDirectives;
    private boolean noCache;
    private List<String> noCaches;
    private boolean noStore;
    private boolean noTransform;
    private boolean mustRevalidate;
    private boolean proxyRevalidate;
    private int maxAge = -1;
    private int sMaxAge = -1;

    public boolean isPrivateDirective() {
        return privateDirective;
    }

    public void setPrivateDirective(boolean privateDirective) {
        this.privateDirective = privateDirective;
    }

    public List<String> getPrivateDirectives() {
        return privateDirectives;
    }

    public void setPrivateDirectives(List<String> privateDirectives) {
        this.privateDirectives = privateDirectives;
    }

    public boolean isNoCache() {
        return noCache;
    }

    public void setNoCache(boolean noCache) {
        this.noCache = noCache;
    }

    public List<String> getNoCaches() {
        return noCaches;
    }

    public void setNoCaches(List<String> noCaches) {
        this.noCaches = noCaches;
    }

    public boolean isNoStore() {
        return noStore;
    }

    public void setNoStore(boolean noStore) {
        this.noStore = noStore;
    }

    public boolean isNoTransform() {
        return noTransform;
    }

    public void setNoTransform(boolean noTransform) {
        this.noTransform = noTransform;
    }

    public boolean isMustRevalidate() {
        return mustRevalidate;
    }

    public void setMustRevalidate(boolean mustRevalidate) {
        this.mustRevalidate = mustRevalidate;
    }

    public boolean isProxyRevalidate() {
        return proxyRevalidate;
    }

    public void setProxyRevalidate(boolean proxyRevalidate) {
        this.proxyRevalidate = proxyRevalidate;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getsMaxAge() {
        return sMaxAge;
    }

    public void setsMaxAge(int sMaxAge) {
        this.sMaxAge = sMaxAge;
    }
}
