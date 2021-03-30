package com.cloudjserv.server.connector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ram Pathak
 * Date: Mar 28 2021
 */
public class Connector implements Runnable {
    private static final Logger logger = Logger.getLogger(Connector.class.getName());

    protected Socket clientSocket;
    protected String id;

    public Connector(Socket clientSocket, String id) {
        this.clientSocket = clientSocket;
        this.id = id;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        logger.info(MessageFormat.format("Processing request: {0}", id));

        InputStream is = null;
        OutputStream os = null;
        try {
            is = clientSocket.getInputStream();
            os = clientSocket.getOutputStream();
            new HttpMethodProcessor().process(is, os);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, ex.toString(), ex);

        } finally {
            try {
                if (os != null) os.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, ex.toString(), ex);
            }
            try {
                if (is != null) is.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, ex.toString(), ex);
            }
            try {
                clientSocket.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, ex.toString(), ex);
            }
        }

    }
}
