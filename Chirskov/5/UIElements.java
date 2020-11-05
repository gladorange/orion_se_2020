import java.util.Iterator;

public class UIElements {
    public static void main(String[] args) {
        UI scene = new UI();
        Button add = new Button("Добавить элемент", 0, 0, 5, 5, new AddElementOnClick(scene));
        TextField coordinateX = new TextField("Координата X для нового элемента", 6, 6, 1, 3);
        TextField coordinateY = new TextField("Координата Y для нового элемента", 6, 8, 1, 3);
        add.click();
        add.click();
        add.click();
        add.click();
        add.click();
        add.click();
        add.click();
        add.click();
        add.click();
        add.click();

        for (Rectangle rectangle : scene.getAllElements()) {
            if (rectangle.getClass() == Button.class
                    && ((Button) rectangle).getCallback().getClass() == AddElementOnClick.class)
                continue;
            System.out.println(rectangle);
            try {
                rectangle.click();
            } catch (Rectangle.ReadOnlyException e) {
                System.out.println(e.getMessage());
            }
            if (rectangle.getClass() == CheckBox.class) {
                System.out.println("Состояние: " + ((CheckBox) rectangle).getCheckBoxState());
            }
            else if (rectangle.getClass() == TextField.class) {
                System.out.println("Текст в поле: " + ((TextField) rectangle).getText());
            }
        }
    }
}
