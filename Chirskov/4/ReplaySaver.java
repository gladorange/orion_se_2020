import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Queue;

public class ReplaySaver {

    private Queue<SomeAction> actions;
    final static String HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
    final static String REPLAY = "Replay";
    private String filename;
    private String winnerInfo;

    ReplaySaver(String filename, Queue<SomeAction> actions, String winnerInfo) {
        this.filename = filename;
        this.actions = actions;
        this.winnerInfo = winnerInfo;
    }

    public void saveReplay() throws IOException, IllegalAccessException {
        final String action = serialize(actions);
        File replay = new File(filename);
        if (replay.exists()) {
            replay.delete();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.append(HEADER)
                .append("< " + REPLAY + ">")
                .append(action)
                .append("< " + WizardWars.RESULT + ">")
                .append(winnerInfo)
                .append("</ " + WizardWars.RESULT + ">\n")
                .append("</ " + REPLAY + ">\n");
        writer.close();
    }

    public static String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        for (Object object : objects) {
            final Class<?> cls = object.getClass();
            final String objectName = Serialize.getObjectName(cls);
            builder.append("<" + objectName + ">\n");
            System.out.println(object);
            addFields(cls.getDeclaredFields(), builder, object);
            addFields(cls.getSuperclass().getDeclaredFields(), builder, object);
            builder.append("</" + objectName + ">\n");
        }
        return builder.toString();
    }

    static void addFields(Field[] declaredFields, StringBuilder builder, Object object) throws IllegalAccessException {
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            System.out.println(declaredField);
            if (declaredField.isAnnotationPresent(XmlIgnore.class) || declaredField.get(object) == null) {
                continue;
            }
            final String fieldName = Serialize.getFieldName(declaredField);
            builder.append("\t\t<" + fieldName + ">" + declaredField.get(object).toString() + "</" + fieldName + ">\n");
        }
    }
}
