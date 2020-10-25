package ru.localcat.helpers;

import ru.localcat.controls.Control;
import ru.localcat.interfaces.RandomlyFilled;

import java.util.ArrayList;
import java.util.Random;

public class RandomElementGenerator {
    //TODO возможно лучше бы подошел HashSet,
    // но если захотим чтобы каких то элементов было случайно быльше, то можно и так
    private ArrayList<Class<? extends Control>> classesList = new ArrayList<>();

    public void addClass(Class<? extends Control> classType) {

        //Хотел чекнуть чтобы можно было добавлять только те классы контролов,
        //которые реализуют интерфейс RandomlyFilled, но при этом
        //не каждый контрол должен реализовать RandomlyFilled, поэтому не вешаю на Control
        //но и не все , кто реализуют RandomlyFilled должны проходить по маске
        //например если бы был класс обертка над строкой, которая может генерировать случайную строку
        //должна реализовывать RandomlyFilled, но при этом она не контрол
        //if(classType instanceof Class<? extends RandomlyFilled>) {};

        classesList.add(classType);
    }

    public Control getRandomElement() throws IllegalAccessException, InstantiationException {
        return classesList.get(new Random().nextInt(classesList.size())).newInstance();
    }
}
