package com.cloudjserv.server.connector;

import com.cloudjserv.server.exception.OperationNotSupportedException;
import com.cloudjserv.server.exception.ServerException;
import com.cloudjserv.server.http.HttpHeaders;
import com.cloudjserv.server.http.Request;
import com.cloudjserv.server.http.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ram Pathak
 * Date: Mar 29 2021
 */
public class HttpMethodProcessor {
    private static final Logger logger = Logger.getLogger(HttpMethodProcessor.class.getName());
    private static final String HEAD = "HEAD";
    private static final String GET = "GET";
    private static final String POST = "POST";


    public void process(InputStream is, OutputStream os) {

        try {
            Request request = Request.buildRequest(is);
            Response resp = this.process(request);
            resp.write(os);
        } catch (IOException | OperationNotSupportedException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            throw new ServerException("Error processing request", e);
        }

    }


    private Response process(Request request) throws OperationNotSupportedException {
        Response response;
        //check the method and process accordingly
        switch (request.getMethod()) {
            case HEAD:
                response = processHead(request);
                break;
            case GET:
                response = processGet(request);
                break;
            case POST:
                response = processPost(request);
                break;
            default:
                throw new OperationNotSupportedException("This method is not supported");

        }
        return response;
    }

    public Response processHead(Request request) {
        return ResponseBuilder.build(request);
    }

    public Response processGet(Request request) {
        return ResponseBuilder.build(request);
    }

    public Response processPost(Request request) {
        throw new ServerException("This method is not supported");
    }

}

class ResponseBuilder {
    private static final String SERVER = "CloudJServ";

    private ResponseBuilder() {
    }

    public static Response build(Request request) {
        //TODO:
        Response response = new Response();
        response.getHeaders().put(HttpHeaders.SERVER.getKey(), SERVER);
        response.getHeaders().put(HttpHeaders.DATE.getKey(), Calendar.getInstance().getTime().toString());
        return response;
    }
}
