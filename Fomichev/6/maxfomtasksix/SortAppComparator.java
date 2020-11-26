package maxfomtasksix;

import java.util.Comparator;

public class SortAppComparator implements Comparator<Triple<String, Double, Double>> {
    @Override
    public int compare(Triple<String, Double, Double> o1, Triple<String, Double, Double> o2) {
        return o1.getSecond().compareTo(o2.getSecond());
    }
}
