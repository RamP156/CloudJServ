package com.cloudjserv;

import com.cloudjserv.server.startup.Bootstrap;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ram Pathak
 * Date: Mar 28 2021
 */
public class CloudJServMain {
    private static final Logger logger = Logger.getLogger(CloudJServMain.class.getName());

    public static void main(String[] args) {
        int port = 8080;
        int poolSize = 5;
        if (args.length == 2) {
            port = Integer.parseInt(args[0]);
            poolSize = Integer.parseInt(args[1]);
        } else if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        }

        Bootstrap boot = new Bootstrap();
        boot.startServer(port, poolSize);

        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, ex.toString(), ex);
        }

        // boot.stoptServer();
    }
}
