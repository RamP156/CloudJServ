package com.cloudjserv.server.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

import static com.cloudjserv.server.utils.HttpUtils.EMPTY_LINE;

/**
 * @author Ram Pathak
 * Date: Mar 28 2021
 */
public final class Request implements HttpRequest {
    private static final Logger logger = Logger.getLogger(Request.class.getName());
    List<String> headers = new ArrayList<>();
    private String method;
    private String path;
    private String version;
    private String host;

    /**
     * Build Request from the incoming Payload.
     * @param is InputStream
     * @return Request
     * @throws IOException, if error building the request
     */
    public static Request buildRequest(InputStream is) throws IOException {
        Request req = new Request();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while (!(line = br.readLine()).isEmpty()) {
            builder.append(line).append(EMPTY_LINE);
        }
        String request = builder.toString();

        logger.info(request);

        //parse request data and get request information
        String[] requestsLines = request.split(EMPTY_LINE);
        String[] requestLine = requestsLines[0].split(" ");
        req.method = requestLine[0];
        req.path = requestLine[1];
        req.version = requestLine[2];
        req.host = requestsLines[1].split(" ")[1];

        //TODO: support query param

        List<String> headers = new ArrayList<>();
        for (int i = 2; i < requestsLines.length; i++) {
            String header = requestsLines[i];
            headers.add(header);
        }
        return req;
    }

    public String getAuthType() {
        return null;
    }

    public long getDateHeader(String var1) {
        return 0;
    }

    public String getHeader(String var1) {
        return null;
    }

    public Enumeration<String> getHeaders(String var1) {
        return null;
    }

    public Enumeration<String> getHeaderNames() {
        return null;
    }

    public int getIntHeader(String var1) {
        return 0;
    }

    public String getMethod() {
        return this.method;
    }

    public String getPathInfo() {
        return this.path;
    }

    public String getPathTranslated() {
        return null;
    }

    public String getContextPath() {
        return null;
    }

    public String getQueryString() {
        return null;
    }

    public String getRemoteUser() {
        return null;
    }

    public boolean isUserInRole(String var1) {
        return false;
    }

    public Principal getUserPrincipal() {
        return null;
    }

    public String getRequestedSessionId() {
        return null;
    }

    public String getRequestURI() {
        return null;
    }

    public StringBuffer getRequestURL() {
        return null;
    }

    public String getServletPath() {
        return null;
    }

    public String changeSessionId() {
        return null;
    }

    public boolean isRequestedSessionIdValid() {
        return false;
    }

    public boolean isRequestedSessionIdFromCookie() {
        return false;
    }

    public boolean isRequestedSessionIdFromURL() {
        return false;
    }
}
