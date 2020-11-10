package com.company;

import java.util.*;

public class Apps {

    public static void main(String[] args) {
        List<Triple<String, Integer, Double>> list = new ArrayList<>();
        list.add(new Triple<>("Telegram", 49,4.5));
        list.add(new Triple<>("Google Chrome", 70,4.2));
        list.add(new Triple<>("YouTube", 30,4.1));
        list.add(new Triple<>("GitHub", 35,4.7));
        list.add(new Triple<>("WhatsApp", 55,4.3));
        showSortedByVotes(list);
        showBestRating(list);
        showWorstRating(list);
    }

    public static void showSortedByVotes(List<Triple<String, Integer, Double>> list) {
        Collections.sort(list, Comparator.comparingInt(Triple::getSecond));
        System.out.println("Приложения, отсортированные по колличеству оценок: " + list);
    }

    public static void showBestRating(List<Triple<String, Integer, Double>> list) {
        Double bestRating = 0.00;
        int bestRatingIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            Triple<String, Integer, Double> app = list.get(i);
            if (app.getThird() > bestRating) {
                bestRating = app.getThird();
                bestRatingIndex = i;
            }
        }
        System.out.println("Приложение с самым лучшим рейтингом - " + list.get(bestRatingIndex));
    }

    public static void showWorstRating(List<Triple<String, Integer, Double>> list) {
        Double worstRating = 5.00;
        int worstRatingIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            Triple<String, Integer, Double> app = list.get(i);
            if (app.getThird() < worstRating) {
                worstRating = app.getThird();
                worstRatingIndex = i;
            }
        }
        System.out.println("Приложение с самым худшим рейтингом - " + list.get(worstRatingIndex));
    }
}
