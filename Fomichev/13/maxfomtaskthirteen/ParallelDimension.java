package maxfomtaskthirteen;

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

public class ParallelDimension {
    static AtomicLong countBytes;

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Collection<URL> list = new ArrayList<>();
        list.add(new URL("http://wtfshouldidowithmylife.com/"));
        list.add(new URL("https://porfirevich.ru/"));
        list.add(new URL("http://wheresthejump.com/"));
        list.add(new URL("http://lines.chromeexperiments.com/"));
        list.add(new URL("http://mhlife.ru/prevention/infections/kid-vaccination-history.html"));
        list.add(new URL("http://annyas.com/screenshots/"));
        list.add(new URL("http://lyst.co.uk/european-fashion-map-2019"));
        list.add(new URL("http://geacron.com/"));
        list.add(new URL("http://krikienoid.github.io/flagwaver/"));
        list.add(new URL("http://vole.wtf/perfect-circle"));
        list.add(new URL("http://movieposterdb.com/"));
        list.add(new URL("http://mecabricks.com/en"));
        list.add(new URL("http://shitday.de/"));
        list.add(new URL("http://money.cnn.com/interactive/news/economy/davos/global-wage-calculator/"));
        list.add(new URL("http://lookslikeyouneediceland.com/"));
        list.add(new URL("http://masswerk.at/google60"));
        list.add(new URL("http://visitorlando.com/en/things-to-do/virtual-tours/walt-disney-world-resort"));
        list.add(new URL("http://festisite.com/money/us_dollar_1/"));
        list.add(new URL("http://thiscatdoesnotexist.com/"));
        list.add(new URL("http://play.aidungeon.io/"));
        loadSequentially(list, "sequential.txt");
        loadParallel(list, "parallel.txt");
    }

    public static void loadSequentially(Collection<URL> list, String fileName) throws IOException {
        Files.deleteIfExists(Path.of(fileName));

        long beginTime = System.currentTimeMillis();
        countBytes = new AtomicLong(0);

        for (URL url : list) {
            String urlContent = readContentFromUrl(url);
            try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                fileWriter.write(urlContent);
            }
            countBytes.updateAndGet(value -> value + urlContent.getBytes().length);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время загрузки: " + (endTime - beginTime) + "мс, размер в байтах: " + countBytes);
    }

    public static void loadParallel(Collection<URL> list, String fileName) throws IOException, ExecutionException, InterruptedException {
        Files.deleteIfExists(Path.of(fileName));

        long beginTime = System.currentTimeMillis();
        countBytes = new AtomicLong(0);
        ExecutorService pool = Executors.newFixedThreadPool(list.size());
        Collection<Future<String>> collection = new CopyOnWriteArrayList<>();
        for (URL url : list) {
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
        System.out.println("Время загрузки: " + (endTime - beginTime) + "мс, размер в байтах: " + countBytes);
    }

    public static String readContentFromUrl(URL list) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(list.openStream()))) {
            sb.append(String.format("===== НАЧАЛО САЙТА <%s> ======\n", list.toString()));
            while (reader.ready()) {
                sb.append(reader.readLine()).append("\n");
            }
            sb.append(String.format("===== КОНЕЦ САЙТА <%s> ======\n", list.toString()));
        }
        return sb.toString();
    }
}
