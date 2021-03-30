package com.cloudjserv.server.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static com.cloudjserv.server.utils.HttpUtils.EMPTY_LINE;

/**
 * @author Ram Pathak
 * Date: Mar 28 2021
 */
public final class Response implements HttpResponse {
    private static final Logger logger = Logger.getLogger(Response.class.getName());
    private static final int BUFF_SIZE = 1024;
    private static final String COLON = ":";
    private final Map<String, String> headers;

    public Response() {
        this.headers = new HashMap<>();
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void write(OutputStream outputStream) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(ResponseEntity.ok());
        bw.write(EMPTY_LINE);

        //TODO:get the resource from the request
        File file = new File("webapp/index.html");

        if (file.canRead()) {
            logger.info(file.getPath());
            //TODO: get the content type dynamically based on the resource
            headers.put(HttpHeaders.CONTENT_TYPE.getKey(), ResponseEntity.getMimeType("html"));
            headers.put(HttpHeaders.CONTENT_LENGTH.getKey(), String.valueOf(file.length()));
            headers.put(HttpHeaders.CACHE_CONTROL.getKey(), "max-age=" + 60 * 60 * 24);//cache for 24 hour?

            //TODO: Support other cache control header like Etag

            for (String header : this.headers.keySet()) {
                bw.write(header + COLON + headers.get(header));
                bw.write(EMPTY_LINE);
            }
            bw.write(EMPTY_LINE);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                char[] buff = new char[BUFF_SIZE];
                int read;
                while ((read = reader.read(buff)) != -1) {
                    bw.write(buff, 0, read);
                }
            }
        }
        bw.flush();
    }
}
