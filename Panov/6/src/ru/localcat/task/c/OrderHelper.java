package ru.localcat.task.c;

import ru.localcat.corteges.Triple;
import ru.localcat.task.b.Raithing;

import java.util.*;

public class OrderHelper {
    //Хотел так List<Triple<? extends Comparable, ? extends Comparable, ? extends Comparable>> appList
    // но чето не прокатило
    public static void sortedList(List<Triple<String, Double, Raithing>> appList,
                                                                  ArgumentType aType,
                                                                  OrderType orderType) {

        switch (aType) {
            case FIRST: {
                Collections.sort(appList, new Comparator<Triple<String, Double, Raithing>>() {
                    @Override
                    public int compare(Triple<String, Double, Raithing> stringDoubleDoubleTriple, Triple<String, Double, Raithing> t1) {
                        if(orderType == OrderType.DESC)
                        {
                            return stringDoubleDoubleTriple.getFirst().compareTo(t1.getFirst());
                        }
                        else
                        {
                            return -1 * stringDoubleDoubleTriple.getFirst().compareTo(t1.getFirst());
                        }
                    }
                });
            }
            case SECOND: {
                Collections.sort(appList, new Comparator<Triple<String, Double, Raithing>>() {
                    @Override
                    public int compare(Triple<String, Double, Raithing> stringDoubleDoubleTriple, Triple<String, Double, Raithing> t1) {
                        if(orderType == OrderType.DESC)
                        {
                            return stringDoubleDoubleTriple.getSecond().compareTo(t1.getSecond());
                        }
                        else
                        {
                            return -1 * stringDoubleDoubleTriple.getSecond().compareTo(t1.getSecond());
                        }
                    }
                });
            }
            case THIRD: {
                Collections.sort(appList, new Comparator<Triple<String, Double, Raithing>>() {
                    @Override
                    public int compare(Triple<String, Double, Raithing> stringDoubleDoubleTriple, Triple<String, Double, Raithing> t1) {
                        if(orderType == OrderType.DESC)
                        {
                            return stringDoubleDoubleTriple.getThird().compareTo(t1.getThird());
                        }
                        else
                        {
                            return -1 * stringDoubleDoubleTriple.getThird().compareTo(t1.getThird());
                        }
                    }
                });
            }
        }

    }
}
