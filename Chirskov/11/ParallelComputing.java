import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;

public class ParallelComputing {
    final static int MAX_THREADS_COUNT = 10;

    static void urlToMapSequential(Set<String> listSet) throws IOException {
        HashMap hashMap = new HashMap();
        for (String url : listSet) {
            hashMap.put(url, new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next());
        }
        writeToFile(hashMap, "sequential.txt");
    }

    static void urlToFileParallel(Set<String> listSet) throws IOException, ExecutionException, InterruptedException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ExecutorService service = Executors.newFixedThreadPool(MAX_THREADS_COUNT);
        for (String url : listSet) {
            final Future<String> submit = service.submit(() -> new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next());
            concurrentHashMap.put(url, submit.get());
        }
        writeToFile(concurrentHashMap, "parallel.txt");
        service.shutdown();
    }

    static void writeToFile(Map map, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        map.forEach((key, value) -> {
            try {
                writer.append("===== НАЧАЛО САЙТА <" + key + "> ======")
                        .append("Содержимое по ссылке: " + value)
                        .append(value.toString())
                        .append("===== КОНЕЦ САЙТА <" + key + "> ======");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        HashSet<String> listSet = new HashSet();
        listSet.add("https://yandex.ru");
        listSet.add("https://google.ru");
        listSet.add("https://yahoo.com");
        listSet.add("https://rambler.ru");
        listSet.add("https://mail.ru");

        File sequentialFile = new File("sequential.txt");
        File parallelFile = new File("parallel.txt");
        if (sequentialFile.exists()){
            sequentialFile.delete();
        }
        if (parallelFile.exists()){
            parallelFile.delete();
        }

        LocalDateTime start = LocalDateTime.now();
        urlToMapSequential(listSet);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Прошло " + ChronoUnit.MILLIS.between(start, end));

        start = LocalDateTime.now();
        urlToFileParallel(listSet);
        end = LocalDateTime.now();
        System.out.println("Прошло " + ChronoUnit.MILLIS.between(start, end));
    }
}

