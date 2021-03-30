package com.cloudjserv.server.http;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ram Pathak
 * Date: Mar 28 2021
 */
public final class ResponseEntity {
    private static final String PROTOCOL = "HTTP/1.1";
    private static final String OK = "OK";
    private static final Map<String, String> MIME_TYPE = new HashMap<>();
    static {
        MIME_TYPE.put("css", "text/css");
        MIME_TYPE.put("gif", "image/gif");
        MIME_TYPE.put("htm", "text/html");
        MIME_TYPE.put("html", "text/html");
        MIME_TYPE.put("js", "application/javascript");
        MIME_TYPE.put("json", "application/json");
        MIME_TYPE.put("jpg", "image/jpeg");
        MIME_TYPE.put("jpeg", "image/jpeg");
        MIME_TYPE.put("pdf", "application/pdf");
        MIME_TYPE.put("png", "image/png");
        MIME_TYPE.put("xml", "application/xml");
        MIME_TYPE.put("zip", "application/zip");
        MIME_TYPE.put("txt", "text/plain");
    }

    private ResponseEntity(){}


    public static String ok() {
        return PROTOCOL + " " + HttpResponse.SC_OK + " " + OK;
    }

    public static String getMimeType(String mimeType) {
        return MIME_TYPE.containsKey(mimeType) ? MIME_TYPE.get(mimeType) : MIME_TYPE.get("txt");
    }
}
