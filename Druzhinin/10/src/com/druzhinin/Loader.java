package com.druzhinin;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class Loader {
    public void loadSequential(Set<URL> urls, String sequenlialFileName) throws IOException {
        long startTime = System.currentTimeMillis();

        Path pathToSequentialFile = Paths.get(sequenlialFileName);
        if (!Files.exists(Path.of(sequenlialFileName))) {
            pathToSequentialFile = Files.createFile(Path.of(sequenlialFileName));
        }

        for (URL url : urls) {
//            System.out.println(url.toString());
            InputStream input = null;
            try {
                input = url.openStream();
            } catch (SSLHandshakeException e) {
                System.out.println(e.getMessage());
            }
            byte[] buffer = input.readAllBytes();
            input.close();
            String str = new String(buffer);

            StringBuilder builder = new StringBuilder();

            builder.append(String.format("===== НАЧАЛО САЙТА %s ======\n", url.toString()));
            builder.append(str + "\n");
            builder.append(String.format("===== КОНЕЦ САЙТА %s ======", url.toString()));

            try {
                pathToSequentialFile = Files.writeString(pathToSequentialFile, builder.toString());
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        long endTime = System.currentTimeMillis();
//        String result = Files.readString(pathToSequentialFile);
        System.out.println("Sequential time: " + (endTime - startTime));
        System.out.println("Size Sequential: " + Files.size(pathToSequentialFile));
    }

    synchronized public void loadParallel(URL urls, String sequenlialFileName) throws IOException {
        Path pathToSequentialFile = Paths.get(sequenlialFileName);

        if (!Files.exists(Path.of(sequenlialFileName))) {
            pathToSequentialFile = Files.createFile(Path.of(sequenlialFileName));
        }
        InputStream input = null;
        try {
            input = urls.openStream();
        } catch (SSLHandshakeException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buffer = input.readAllBytes();
        input.close();
        String str = new String(buffer);

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("===== НАЧАЛО САЙТА %s ======\n", urls.toString()));
        builder.append(str + "\n");
        builder.append(String.format("===== КОНЕЦ САЙТА %s ======", urls.toString()));

        try {
            pathToSequentialFile = Files.writeString(pathToSequentialFile, builder.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
