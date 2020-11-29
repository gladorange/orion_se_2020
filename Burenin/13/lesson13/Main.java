package lesson13;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    static AtomicLong countBytes;
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Collection<URL> urls = new ArrayList<>();
        urls.add(new URL("https://yandex.ru/"));
        urls.add(new URL("https://www.google.com/"));
        urls.add(new URL("https://vk.com/"));
        urls.add(new URL("https://www.facebook.com/"));
        urls.add(new URL("https://ru.wikipedia.org/"));
        urls.add(new URL("http://htmlbook.ru/"));
        urls.add(new URL("https://javarush.ru/"));
        urls.add(new URL("https://ok.ru/"));
        urls.add(new URL("https://stackoverflow.com/"));
        urls.add(new URL("https://www.instagram.com/"));
        urls.add(new URL("https://www.youtube.com/"));
        urls.add(new URL("https://mail.ru/"));
        urls.add(new URL("https://www.avito.ru/"));
        urls.add(new URL("https://www.ozon.ru/"));
        urls.add(new URL("https://hh.ru/"));
        urls.add(new URL("https://apteka.ru/"));
        urls.add(new URL("https://www.biglion.ru/"));
        urls.add(new URL("https://www.whatsapp.com/"));
        urls.add(new URL("https://github.com/"));
        urls.add(new URL("https://docs.oracle.com/"));
        loadSequentially(urls, "sequential.txt");
        loadParallel(urls, "parallel.txt");
    }

    public static void loadSequentially(Collection<URL> urls, String fileName) throws IOException {
        Files.deleteIfExists(Path.of(fileName));

        long beginTime = System.currentTimeMillis();
        countBytes = new AtomicLong(0);

        for (URL url : urls) {
            String urlContent = readContentFromUrl(url);
            try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                fileWriter.write(urlContent);
            }
            countBytes.updateAndGet(value -> value + urlContent.getBytes().length);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - beginTime) + "ms, byte size: " + countBytes);
    }

    public static void loadParallel(Collection<URL> urls, String fileName) throws IOException, ExecutionException, InterruptedException {
        Files.deleteIfExists(Path.of(fileName));

        long beginTime = System.currentTimeMillis();
        countBytes = new AtomicLong(0);
        ExecutorService pool = Executors.newFixedThreadPool(urls.size());
        Collection<Future<String>> collection = new CopyOnWriteArrayList<>();
        for (URL url : urls) {
            collection.add(pool.submit(() -> readContentFromUrl(url)));
        }

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            for (Future<String> future : collection) {
                String content = future.get();
                fileWriter.write(content);
                countBytes.updateAndGet(value -> value + content.getBytes().length);
            }
        }
        pool.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - beginTime) + "ms, byte size: " + countBytes);
    }

    private static String readContentFromUrl(URL url) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            builder.append(String.format("===== НАЧАЛО САЙТА <%s> ======\n", url.toString()));
            while (reader.ready()) {
                builder.append(reader.readLine()).append("\n");
            }
            builder.append(String.format("===== КОНЕЦ САЙТА <%s> ======\n", url.toString()));
        }
        return builder.toString();
    }
}
