import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WizardWars {
    private static boolean IS_REPLAY = false;
    final static String FILENAME = "Replay.xml";
    final static String RESULT = "Result";

    public static void main(String[] args) throws IllegalAccessException, IOException {
        ActionProducer producer;
        boolean isReplayExists = new File(FILENAME).exists();
        if (isReplayExists && askYesNoQuestion("Воспроизвести сохраненную игру? (Нет - начать новую)")) {
            producer = new ReplayActionProducer(ReplayGameInitializerProducer.initActions());
            IS_REPLAY = true;
        } else {
            producer = new RandomGameActionProducer(RandomGameInitializerProducer.initCharacters());
        }
        producer.play();
        if (!IS_REPLAY && askYesNoQuestion("Хотите сохранить реплей? Да\\Нет")) {
            ReplaySaver replaySaver = new ReplaySaver(FILENAME,
                                      ((RandomGameActionProducer) producer).getActions(),
                                      ((RandomGameActionProducer) producer).getInfo());
            replaySaver.saveReplay();
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
}

