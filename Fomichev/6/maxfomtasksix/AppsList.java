package maxfomtasksix;

import java.util.ArrayList;
import java.util.List;

public class AppsList {
    String name;
    double count;
    double rating;

    @Override
    public String toString() {
        return "AppsList{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", rating=" + rating +
                '}';
    }

    static void sortCount(List<Triple<String, Double, Double>> sortApp) {
        sortApp.sort(new SortAppComparator());
        System.out.println("Выводим приложения по количеству оценок: \n" + sortApp);
    }
    
    static void worseApp(List<Triple<String, Double, Double>> worseApp) {
        double min = Double.MAX_VALUE;
        String badApp = null;
        for (Triple<String, Double, Double> list : worseApp) {
            if (list.getThird() < min) {
                min = list.getThird();
                badApp = list.getFirst();
            }
        }
        System.out.println("Худшее приложение по оценкам: " + badApp  + " - его рейтинг " + min);
    }

    static void bestApp(List<Triple<String, Double, Double>> worseApp) {
        double max = 0;
        String bestApp = "";
        for (Triple<String, Double, Double> list : worseApp) {
            if (list.getThird() > max) {
                max = list.getThird();
                bestApp = list.getFirst();
            }
        }
        System.out.println("Лучшее приложение по оценкам: " + bestApp + " - его рейтинг " + max);
    }


    public static void main(String[] args) {
        List<Triple<String, Double, Double>> list = new ArrayList<>();
        list.add(new Triple<>("Facebook", 255.5, 1.5));
        list.add(new Triple<>("Яндекс.Еда", 331.7, 4.5));
        list.add(new Triple<>("Shazam", 445.5, 3.5));
        list.add(new Triple<>("Uber", 15.3, 4.9));
        list.add(new Triple<>("Вятский Банк", 100.2, 4.1));
        AppsList.sortCount(list);
        AppsList.worseApp(list);
        AppsList.bestApp(list);
    }

}
