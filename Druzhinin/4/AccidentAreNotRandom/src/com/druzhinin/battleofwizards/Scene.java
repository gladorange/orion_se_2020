package com.druzhinin.battleofwizards;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Cell {
    Character character;

    public Cell(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}

public class Scene {

    final private String[] monsterNames = {"Вурдалак", "Леший", "Водяной",
            "Оборотень", "Пиявочник", "Бородавочник"};
    final private String[] wizardNames = {"Сократиус", "Эректус", "Алхимикус"};

    private int KINDS_OF_CHARACTER = 2;

    private Cell[][] field;
    private int width;
    private int height;

    private Character activeCharacter = null;

    public Scene(int width, int height) {
        this.width = width;
        this.height = height;
        field = new Cell[this.width][this.height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                field[i][j] = new Cell(getRandomCharacter());
            }
        }
    }

    void fillScene() {
        Random random = new Random();
        int numberOfCharacters = random.nextInt(field.length);
    }

    private Character getRandomCharacter() {
        Random random = new Random();

        int kindOfCharacter = random.nextInt(KINDS_OF_CHARACTER + 2);
        switch (kindOfCharacter) {
            case 0:
            case 1:
                int indexOfMonster = random.nextInt(monsterNames.length);
                return new Monster(monsterNames[indexOfMonster], indexOfMonster + 1);
            case 2:
                int indexOfWizard = random.nextInt(wizardNames.length);
                return new Wizard(wizardNames[indexOfWizard], indexOfWizard + 1);
        }
        return null;
    }

    public void run() {
        while (true) {

            // убираем с проля трупы и считаем количество оставшихся персонажей
            int counterOfCharacters = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    Character checkedCharacter = field[i][j].getCharacter();

                    if (checkedCharacter != null) {
                        counterOfCharacters++;
                        if (checkedCharacter.getHealth() <= 0) {
                            field[i][j].setCharacter(null);
                        }
                    }
                }
            }

            // объявляем победителя
            if (counterOfCharacters == 1) {
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        Character checkedCharacter = field[i][j].getCharacter();

                        if (checkedCharacter != null) {
                            System.out.println("Персонаж: " + checkedCharacter.getName() + " победил");
                        }
                    }
                }
            }

            System.out.println(toString());
            Scanner in = new Scanner(System.in);

            int checkedHeight;
            int checkedWidth;

            Character character;

            while (true) {

                System.out.println("выберите координату по вертикали [i][]");
                checkedHeight = in.nextInt();

                System.out.printf("выберите координату по горизонтали [%d][j]\n", checkedHeight);
                checkedWidth = in.nextInt();
                character = field[checkedHeight][checkedWidth].getCharacter();

                if (character != activeCharacter) {
                    activeCharacter = character;
                    break;
                }
                else {
                    System.out.println("Этот персонаж уже совершил ход, выберите другого персонажа");
                }
            }

            if (character.getHealth() <= 0) {
                character = null;
            }
            if (character == null) {
                System.out.println("на этой ячейке нет первонажей, выберите заново");
                continue;
            } else if (character instanceof Monster) {
                System.out.printf("\nЗдесь %s\n", field[checkedHeight][checkedWidth].getCharacter().toString());
                System.out.println("выберите вертикаль для атаки [i][]");
                int attackHeight = in.nextInt();
                System.out.printf("выберите горизонталь для атаки [%d][j]\n", attackHeight);
                int attackWidth = in.nextInt();
                character.attack();

                Monster currentMonster = (Monster) character;
                field[attackHeight][attackWidth].getCharacter().decreaseHealth(currentMonster.getDemagePower());
            } else if (character instanceof Wizard) {
                Wizard currentWizard = (Wizard) character;

                System.out.printf("\nЗдесь %s\n", field[checkedHeight][checkedWidth].getCharacter().toString());

                System.out.println("выберите заклинание [1, 2, 3]");
                int spell = in.nextInt();
                currentWizard.setCheckedSpell(spell);

                if (currentWizard.getCurrentSpell() instanceof SpellMigraine) {
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            Character attackedCharacter = field[i][j].getCharacter();

                            if (attackedCharacter instanceof Wizard & attackedCharacter != null) {
                                attackedCharacter.decreaseHealth(1);
                            }
                        }
                    }
                } else if (currentWizard.getCurrentSpell() instanceof SpellWallOfFire) {
                    int position = 1;
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            Character attackedCharacter = field[i][j].getCharacter();

                            if ((position % 2) == 0) {
                                if (attackedCharacter != null) {
                                    attackedCharacter.decreaseHealth(1);
                                }
                            }
                            position++;
                        }
                    }
                } else if (currentWizard.getCurrentSpell() instanceof SpellBanishingMonsters) {
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            Character attackedCharacter = field[i][j].getCharacter();

                            if (attackedCharacter instanceof Monster & attackedCharacter != null) {
                                attackedCharacter.decreaseHealth(1);
                            }
                        }
                    }
                } else if (currentWizard.getCurrentSpell() instanceof SpellChainLightning) {
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            Character attackedCharacter = field[i][j].getCharacter();

                            if (attackedCharacter != null & attackedCharacter != currentWizard) {
                                attackedCharacter.decreaseHealth(1);
                            }
                        }
                    }
                } else if (currentWizard.getCurrentSpell() instanceof SpellFireTouch) {
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            Character currentCharacter = field[i][j].getCharacter();

                            if (currentCharacter.equals(currentWizard)) {
                                Character attackedCharacter = null;

                                for (int I = i - 1; I <= i + 1; I++) {
                                    for (int J = j - 1 ; J <= j + 1; J++) {
                                        if (I < 0 | I > width | J < 0 | J > height) {
                                            continue;
                                        }

                                        attackedCharacter = field[i + 1][j + 1].getCharacter();
                                        attackedCharacter.decreaseHealth(1);
                                    }
                                }
                            }
                        }
                    }
                }
                currentWizard.attack();
            }
        }
    }

    @Override
    public String toString() {
        String scene = new String();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Character person = field[i][j].getCharacter();

                scene += "\n" + "[" + i + "]" + "[" + j + "] : ";
                scene += person != null ?
                        person + "\n" : "NOT";
            }
        }
        return scene;
    }
}
