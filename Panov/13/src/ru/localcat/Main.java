package ru.localcat;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    static AtomicLong case1DataSize;
    static final String rootUrl = "http://localhost:81/info/hw13.php?page_id=";


    public static void main(String[] args) throws MalformedURLException, ExecutionException, InterruptedException {
        // write your code here

        long m1 = System.currentTimeMillis();
        case1DataSize = new AtomicLong(0);

        List<String> urlList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            urlList.add(rootUrl + i);
        }


        //case 1

        for (String s : urlList) {
            StringBuilder stringBuilder = new StringBuilder();
            UrlContentDTO urlContentDTO = UrlLoaderHelper.getContentByUrl(s);

            stringBuilder.append("===== НАЧАЛО САЙТА ").append(s).append(" ====== \n");
            stringBuilder.append(urlContentDTO.getContent()).append("\n");
            stringBuilder.append("===== КОНЕЦ САЙТА ").append(s).append(" ====== \n");

            System.out.println(stringBuilder.toString());

            case1DataSize.updateAndGet(n -> n + urlContentDTO.getContentSize());
        }

        System.out.println("Time for Case1 work = " + (System.currentTimeMillis() - m1) + ", dataSize = " + case1DataSize.toString());

        // Time for Case1 work = 72, dataSize = 1031, время меняетсья размер нет


        System.out.println("            ---------------------       ");
        System.out.println("            ---------------------       ");
        System.out.println("            ---------------------       ");
        System.out.println("            ---------------------       ");
        System.out.println("            ---------------------       ");
        System.out.println("            ---------------------       ");

        //case 2

        case1DataSize = new AtomicLong(0);
        //Для
        // ExecutorService executorService = Executors.newFixedThreadPool(1);
        //Считает быстре чем для
        //Для
        //ExecutorService executorService = Executors.newFixedThreadPool(urlList.size());
        //????????????????
        ExecutorService executorService = Executors.newFixedThreadPool(1);


        long m2 = System.currentTimeMillis();
        //Фъуче джэнераизируеться UrlContentDTO, потмоучто я ленивый, а дтошка очень подхожит под нужду))
        List<Future<UrlContentDTO>> result = new ArrayList<>();
        for (String s : urlList) {
            Future<UrlContentDTO> submit = executorService.submit(new Callable<UrlContentDTO>() {
                @Override
                public UrlContentDTO call() {
                    UrlContentDTO urlContentDTO = null;
                    StringBuilder stringBuilder = new StringBuilder();
                    try {
                        urlContentDTO = UrlLoaderHelper.getContentByUrl(s);
                        final int size = urlContentDTO.getContentSize();


                        stringBuilder.append("===== НАЧАЛО САЙТА ").append(s).append(" ====== \n");
                        stringBuilder.append(urlContentDTO.getContent()).append("\n");
                        stringBuilder.append("===== КОНЕЦ САЙТА ").append(s).append(" ====== \n");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    return new UrlContentDTO(urlContentDTO.getContentSize(), stringBuilder.toString());
                }
            });
            result.add(submit);
        }

        for (Future<UrlContentDTO> urlContentDTOFuture : result) {
            System.out.println(urlContentDTOFuture.get().getContent());
            case1DataSize.getAndUpdate(n -> {
                try {
                    return n + urlContentDTOFuture.get().getContentSize();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return n;
            });
        }

        System.out.println("Time for Case2 work = " + (System.currentTimeMillis() - m2) + ", dataSize = " + case1DataSize.toString());
        executorService.shutdown();

    }
}
