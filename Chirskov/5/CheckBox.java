import java.util.concurrent.ThreadLocalRandom;

public class CheckBox extends Rectangle {
    boolean checkBoxState = ThreadLocalRandom.current().nextBoolean();
    CheckBox(){
    }

    CheckBox(String caption, int x, int y, int height, int width) {
        super(caption, x, y, height, width);
    }

    @Override
    public String toString() {
        return  "Чекбокс " + super.caption + " в <" + x + "," + y
                + "> с высотой: " + height + " и шириной: " + width;
    }

    public boolean getCheckBoxState() {
        return checkBoxState;
    }

    @Override
    public void click() {
        try {
            super.click();
            checkBoxState = !checkBoxState;
        } catch (ReadOnlyException error) {
            System.out.println(error.getMessage());
        }
        System.out.println("Меняем состояние чекбокс с " + !checkBoxState + " на " + checkBoxState);
    }
}
