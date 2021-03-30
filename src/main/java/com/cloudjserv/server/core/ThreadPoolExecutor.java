package com.cloudjserv.server.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * It is a wrapper around Java ExecutorService and provides convenient method to control the thread pool size.
 *
 * @author Ram Pathak
 * Date: Mar 28 2021
 */
public class ThreadPoolExecutor {
    //ideally it should come from a config/property file
    private static final int MAX_THREADS = 100;
    private static final int DEFAULT_THREADS = 5;
    private int nThreads = DEFAULT_THREADS;
    private final ExecutorService pool =
            Executors.newFixedThreadPool(nThreads);

    public ThreadPoolExecutor(int nThreads) {
        if (nThreads > 0 && nThreads <= MAX_THREADS) this.nThreads = nThreads;
    }

    public ExecutorService getPool() {
        return pool;
    }
}
