package com.druzhinin;

import java.io.IOException;
import java.net.URL;

public class LoadThread implements Runnable {
    Thread thread;
    Loader loader;
    URL url;
    String fileName;

    public LoadThread(Loader loader, URL url, String fileName) {
        this.thread = new Thread(this);
        this.loader = loader;
        this.url = url;
        this.fileName = fileName;

        thread.start();
    }

    @Override
    public void run() {
        try {
            loader.loadParallel(url, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
