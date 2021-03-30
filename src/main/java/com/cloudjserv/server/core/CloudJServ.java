package com.cloudjserv.server.core;

import com.cloudjserv.server.connector.Connector;
import com.cloudjserv.server.exception.LifecycleException;
import com.cloudjserv.server.exception.ServerException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the CloudJServ Web Server implementation.
 *
 * @author Ram Pathak
 * Date: Mar 28 2021
 */
public class CloudJServ implements Runnable {
    private static final Logger logger = Logger.getLogger(CloudJServ.class.getName());
    private final ThreadPoolExecutor executor;
    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;

    public CloudJServ(int port, int poolSize) {
        this.serverPort = port;
        this.executor = new ThreadPoolExecutor(poolSize);
    }

    public void run() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new LifecycleException("Error Starting CloudJServ", ex);
        }

        while (!isStopped()) {
            Socket clientSocket;
            try {
                clientSocket = this.serverSocket.accept();
                clientSocket.setKeepAlive(true);
            } catch (IOException ex) {
                if (isStopped()) {
                    break;
                }
                logger.log(Level.SEVERE, ex.getMessage(), ex);

                throw new LifecycleException(
                        "Error accepting client connection", ex);
            }

            this.executor.getPool().execute(new Connector(clientSocket,
                    UUID.randomUUID().toString()));
        }
        this.executor.getPool().shutdown();
        logger.fine("Server Stopped");
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new ServerException("Error closing server", e);
        }
    }
}
