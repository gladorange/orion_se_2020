import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class WizardWars {
    private static boolean isReplay = false;
    final static String filename = "Replay.xml";
    final static String header = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";

    public static void main(String[] args) throws IllegalAccessException, IOException {

        ActionProducer producer;
        if (new File(filename).exists()) {
            if (askYesNoQuestion("Воспроизвести сохраненную игру? (Нет - начать новую)")) {
                producer = new ReplayActionProducer();
                isReplay = true;
            } else {
                producer = new RandomGameActionProducer();
            }
        } else {
            producer = new RandomGameActionProducer();
        }
        producer.initCharacters();
        producer.play();
        if (!isReplay && askYesNoQuestion("Хотите сохранить реплей? Да\\Нет")) {
            final String action = save(producer);
            File replay = new File(filename);
            if (replay.exists()) {
                replay.delete();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.append(header)
                    .append("<Replay>\n")
                    .append(action)
                    .append("</Replay>\n");
            writer.close();
        }
    }

    public static boolean askYesNoQuestion(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        while (true) {
            String decision = scanner.nextLine();
            switch (decision) {
                case "да":
                    return true;
                case "нет":
                    return false;
                default:
                    System.out.println("Вы ввели неверное значение");
            }
        }
    }

    public static String save(ActionProducer producer) throws IllegalAccessException {
        return serialize(producer.getActions());
    }

    public static String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        if (isReplay)
            return builder.toString();
        for (Object object : objects) {
            final Class<?> cls = object.getClass();
            final String objectName = Serialize.getObjectName(cls);
            builder.append("<" + objectName + ">\n");
            addFields(cls.getDeclaredFields(), builder, object);
            addFields(cls.getSuperclass().getDeclaredFields(), builder, object);
            builder.append("</" + objectName + ">\n");
        }
        return builder.toString();
    }

    static void addFields(Field[] declaredFields, StringBuilder builder, Object object) throws IllegalAccessException {
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.isAnnotationPresent(XmlIgnore.class) || declaredField.get(object) == null) {
                continue;
            }
            final String fieldName = Serialize.getFieldName(declaredField);
            builder.append("\t\t<" + fieldName + ">" + declaredField.get(object).toString() + "</" + fieldName + ">\n");
        }
    }
}

