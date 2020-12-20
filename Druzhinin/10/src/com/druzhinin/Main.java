package com.druzhinin;

import javax.net.ssl.SSLHandshakeException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        final String sequenlialFileName = "/home/evgeny/sequential.txt";

        Set<URL> urlSet = new CopyOnWriteArraySet<>();

        urlSet.add(new URL("https://ya.ru"));
        urlSet.add(new URL("https://google.ru"));
        urlSet.add(new URL("https://youtube.com"));
        urlSet.add(new URL("https://mail.ru"));
        urlSet.add(new URL("https://mcdonalds.ru"));
        urlSet.add(new URL("https://amperka.ru"));
        urlSet.add(new URL("https://harman.com"));
        urlSet.add(new URL("https://orioninc.com"));
        urlSet.add(new URL("https://javarush.ru"));
        urlSet.add(new URL("https://github.com"));
        urlSet.add(new URL("https://stackoverflow.com"));
        urlSet.add(new URL("https://iaea.org"));
        urlSet.add(new URL("https://heinekenrussia.ru"));
        urlSet.add(new URL("https://iter.org"));
        urlSet.add(new URL("https://vk.com"));
        urlSet.add(new URL("https://varian.com"));
        urlSet.add(new URL("https://elekta.com"));
        urlSet.add(new URL("https://nature.com"));
        urlSet.add(new URL("https://ubuntu.com"));
        urlSet.add(new URL("https://tass.ru"));

        Loader loader = new Loader();
        loader.loadSequential(urlSet, sequenlialFileName);

        long startTime = System.currentTimeMillis();
        for (URL url : urlSet) {
            LoadThread loadThread = new LoadThread(loader, url, sequenlialFileName);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel time: " + (endTime - startTime));
        System.out.println("Size Parallel: " + Files.size(Paths.get(sequenlialFileName)));
    }
}
