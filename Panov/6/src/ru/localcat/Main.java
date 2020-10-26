package ru.localcat;

import ru.localcat.corteges.Pair;
import ru.localcat.corteges.Triple;
import ru.localcat.task.a.Animal;
import ru.localcat.task.a.AnimalHelper;
import ru.localcat.task.b.GasolineHelper;
import ru.localcat.task.b.GasolineType;
import ru.localcat.task.b.Raithing;
import ru.localcat.task.c.ArgumentType;
import ru.localcat.task.c.OrderHelper;
import ru.localcat.task.c.OrderType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //task A
        List<Pair<Animal, String>> animalList = new ArrayList<>();
        animalList.add(new Pair(new Animal("Коала", "Мишка"), "Эвакалипт"));
        animalList.add(new Pair(new Animal("Гризли", "Мишка"), "Мясо"));
        animalList.add(new Pair(new Animal("Пума", "Кошка"), "Мясо"));

        AnimalHelper.feedAnimal(animalList);

        System.out.println("______________________________");
        //task B

        List<Triple<String, GasolineType,Double>> gasolinesList= new ArrayList<>();
        gasolinesList.add(new Triple<>("ул. Случайная, 764", GasolineType.DT, 35.0));
        gasolinesList.add(new Triple<>("ул. Фруктовая, 92", GasolineType.AI92, 50.0));
        gasolinesList.add(new Triple<>("ул. Чайная,22 ", GasolineType.AI92, 40.0));
        gasolinesList.add(new Triple<>("ул. Абрикосовая, 8", GasolineType.AI95, 30.0));
        gasolinesList.add(new Triple<>("ул. Имени 2000 лет революции, 3", GasolineType.AI95, 41.0));
        gasolinesList.add(new Triple<>("Переулок Джавовый, 42", GasolineType.AI92, 51.0));
        gasolinesList.add(new Triple<>("ул. Образцовая, 12", GasolineType.AI98, 55.0));

        GasolineHelper.findBestPrice(gasolinesList, GasolineType.AI92);


        System.out.println("______________________________");
        //task C

        //Чуть в разрез с  заданием, вообще хотел отнаследоваться от Double,
        //но он финализирован (
        List<Triple<String,Double,Raithing>> appsList = new ArrayList<>();

        appsList.add(new Triple<>("VK", 5000.0, new Raithing(3.3)));
        appsList.add(new Triple<>("Facebook", 50001100.0, new Raithing(4.1)));
        appsList.add(new Triple<>("Viber", 234500001.0, new Raithing(4.3)));
        appsList.add(new Triple<>("Whatsapp", 764500001.0, new Raithing(4.4)));
        appsList.add(new Triple<>("Telegram", 80000000.0, new Raithing(5.0)));
        appsList.add(new Triple<>("GitHub", 20000000.0, new Raithing(4.7)));
        //В память о прекрасном продукте, закрытым Гуглом
        //https://en.wikipedia.org/wiki/Inbox_by_Gmail
        appsList.add(new Triple<>("Inbox", 1000000000.0, new Raithing(5.0)));

        System.out.println("RAW apps list \n" + appsList);

        //Не так сортирует как ожидаеться... отсюда вопрос, что я делаю не так и как праивльно сортировать строки,
        // если я хочу это делать через компаратор, делать обертку типа как с Рэйтингом?
        OrderHelper.sortedList(appsList, ArgumentType.FIRST, OrderType.ASC);
        System.out.println("Sort by name " + appsList);

        OrderHelper.sortedList(appsList, ArgumentType.SECOND, OrderType.ASC);
        System.out.println("Sort by count raithing " + appsList);

        OrderHelper.sortedList(appsList, ArgumentType.THIRD, OrderType.ASC);
        System.out.println("Sort by best raithing " + appsList);

        OrderHelper.sortedList(appsList, ArgumentType.THIRD, OrderType.DESC);
        System.out.println("Sort by fail raithing " + appsList);

    }
}
