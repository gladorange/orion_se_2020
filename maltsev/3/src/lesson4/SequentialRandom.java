package lesson4;

import java.util.Random;

public final class SequentialRandom {
    private static int lastNum;
    private static boolean isFirst = true;
    private int intNum;

    static void resetRandom()
    {
        isFirst = true;
    }

    public int getIntNum() {
        return intNum;
    }

    SequentialRandom() {
        if (isFirst) {
            isFirst = false;
            this.intNum = new Random().nextInt(100);
            lastNum = this.intNum;
        }else{
            this.intNum = 1 + this.lastNum;
            lastNum = this.intNum;
        }

        System.out.println(this.getIntNum());

    }

}
