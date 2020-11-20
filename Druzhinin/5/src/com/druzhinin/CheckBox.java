package com.druzhinin;

public class CheckBox extends Rectangle implements Clickable {
    private boolean checked;
    private final int id;
    private static int iD = 0;

    public CheckBox() {
        iD++;
        id = iD;
    }

    public CheckBox(int x, int y, int width, int height, String caption, boolean active) {
        super(new Point(x, y), width, height, caption, active);
        iD++;
        id = iD;
    }

    @Override
    public void click() {
         if (!active) {
            throw new ReadOnlyException("Can not change inactive state for checkBox with id = " + id);
         }

        if (checked) {
            checked = false;
            System.out.printf("Make checkBox with id = %s unchecked\n", id);
        } else {
            checked = true;
            System.out.printf("Make checkBox with id = %s checked\n", id);
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CheckBox{" +
                "checked=" + checked +
                ", id=" + id +
                ", point=" + point +
                ", width=" + width +
                ", height=" + height +
                ", caption='" + caption + '\'' +
                ", active=" + active +
                '}';
    }
}
