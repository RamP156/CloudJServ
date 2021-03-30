package com.cloudjserv.server.startup;

import com.cloudjserv.server.core.CloudJServ;

import java.util.logging.Logger;

/**
 * @author Ram Pathak
 * Date: Mar 29 2021
 */
public final class Bootstrap {
    private static final Logger logger = Logger.getLogger(Bootstrap.class.getName());
    private CloudJServ server;

    public void startServer(int port, int poolSize) {
        logger.info("This is CloudJServ Web Server.");

        server = new CloudJServ(port, poolSize);
        new Thread(server).start();
        logger.info("CloudJServ is running...");
    }

    public void stoptServer() {
        logger.info("CloudJServ is stopping...");
        server.stop();
    }
}
