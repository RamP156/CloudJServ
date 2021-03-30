package com.cloudjserv.server.http;

import java.security.Principal;
import java.util.Enumeration;

/**
 * It defines method to handle HTTP request. *
 * @author Ram Pathak
 * Date: Mar 28 2021
 */
public interface HttpRequest {

    String getAuthType();

    long getDateHeader(String var1);

    String getHeader(String var1);

    Enumeration<String> getHeaders(String var1);

    Enumeration<String> getHeaderNames();

    int getIntHeader(String var1);

    String getMethod();

    String getPathInfo();

    String getPathTranslated();

    String getContextPath();

    String getQueryString();

    String getRemoteUser();

    boolean isUserInRole(String var1);

    Principal getUserPrincipal();

    String getRequestedSessionId();

    String getRequestURI();

    StringBuffer getRequestURL();

    String getServletPath();


    String changeSessionId();

    boolean isRequestedSessionIdValid();

    boolean isRequestedSessionIdFromCookie();

    boolean isRequestedSessionIdFromURL();


}
