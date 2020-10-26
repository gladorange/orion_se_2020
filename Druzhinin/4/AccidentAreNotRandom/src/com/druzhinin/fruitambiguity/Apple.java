package com.druzhinin.fruitambiguity;

public class Apple extends Fruit {
    public String getColor() {
        return color;
    }

    public void setColor(String colorOfApple) {
        colorOfApple = colorOfApple.toUpperCase();
        if (colorOfApple == COLORS.RED.name() | colorOfApple == COLORS.GREEN.name() |
                colorOfApple == COLORS.YELLOW.name()) {
            color = colorOfApple;
        } else {
            System.out.println("Incorrect color, set: " + COLORS.RED.name());
            color = COLORS.RED.name();
        }
    }

    private String color;

    @Override
    public String toString() {
        return "Apple{" + "weight='" + super.getWeight() + '\'' +
                "color='" + color + '\'' +
                '}';
    }
}
