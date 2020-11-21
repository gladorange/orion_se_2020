package shilkin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        System.out.println(getType());
        System.out.println(getNameList(getType()).get(0));
        System.out.println(getNameList(getType()).get(1));
        System.out.println(getNameList(getType()).get(2));

    }

    static private int getType(){
        Random random = new Random();
        return random.nextInt(2);
    }

    static List<String> getNameList(int type) {
        List<String> mageNames = new ArrayList<>();
        mageNames.add("Сакура");
        mageNames.add("Иллия");
        mageNames.add("Широ");
        mageNames.add("Кирей");
        mageNames.add("Эмия");
        mageNames.add("Токо");
        mageNames.add("Кайнет");
        mageNames.add("Лорелей");
        mageNames.add("Тосака");
        mageNames.add("Генрих");
        List<String> monsterNames = new ArrayList<>();
        monsterNames.add("Цербер");
        monsterNames.add("Гидра");
        monsterNames.add("Гарпия");
        monsterNames.add("Химера");
        monsterNames.add("Горгона");
        monsterNames.add("Василиск");
        monsterNames.add("Гоблин");
        monsterNames.add("Банши");
        monsterNames.add("Тролль");
        monsterNames.add("Грифон");
        if (type == 0) {
            return monsterNames;
        }
        return mageNames;
    }
}
